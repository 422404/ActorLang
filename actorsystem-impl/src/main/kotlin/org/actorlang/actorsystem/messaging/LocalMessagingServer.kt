package org.actorlang.actorsystem.messaging

import mu.KotlinLogging
import org.actorlang.actorsystem.ServerLikeState
import org.actorlang.actorsystem.messaging.exception.NoMailboxRegisteredForActorRefException
import org.actorlang.actorsystem.messaging.exception.NoMailboxRegisteredForMessageTargetException
import org.actorlang.actorsystem.messaging.exception.NonLocalActorRefException
import java.util.Optional
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock
import kotlin.Exception
import kotlin.concurrent.withLock

private val logger = KotlinLogging.logger {}

class LocalMessagingServer : MessagingServer {

    private val stateLock = ReentrantLock()
    private var state = ServerLikeState.CREATED
    private val mailboxes = ConcurrentHashMap<LocalActorRef, Mailbox>()
    private val pendingMessages = ArrayDeque<Message>()
    private val pendingMessagesLock = ReentrantLock()
    private val newMessageCondition = pendingMessagesLock.newCondition()
    private var mustStop = false

    private val dispatcherThread = Thread {
        do {
            try {
                dispatchNextMessage()
            } catch (e: Exception) {
                logger.error("Exception thrown in dispatcher thread", e)
            }
        } while (!mustStop)
    }

    override fun sendMessage(message: Message) {
        if (message.target !is LocalActorRef) {
            throw NonLocalActorRefException()
        }

        pendingMessagesLock.withLock {
            // When add the message to the head of the queue
            pendingMessages.addFirst(message)
            newMessageCondition.signal()
        }
    }

    override fun tryGetMessage(actorRef: LocalActorRef, timeoutMillis: Long): Optional<Message> {
        return mailboxes[actorRef]?.tryGetMessage(timeoutMillis)
            ?: throw NoMailboxRegisteredForActorRefException(actorRef)
    }

    override fun registerMailbox(actorRef: LocalActorRef, mailbox: Mailbox) {
        mailboxes[actorRef] = mailbox
    }

    override fun unregisterMailbox(actorRef: LocalActorRef) {
        mailboxes.remove(actorRef)
    }

    override fun start() {
        stateLock.withLock {
            if (state == ServerLikeState.CREATED) {
                state = ServerLikeState.STARTED
                dispatcherThread.start()
            }
        }
    }

    override fun shutdown(timeoutMillis: Long) {
        stateLock.withLock {
            if (state == ServerLikeState.STARTED) {
                state = ServerLikeState.STOPPED
                mustStop = true
                pendingMessagesLock.withLock {
                    newMessageCondition.signal()
                }
                dispatcherThread.join(timeoutMillis)
            }
        }
    }

    private fun dispatchNextMessage() {
        pendingMessagesLock.withLock {
            if (pendingMessages.isEmpty()) {
                newMessageCondition.await()
            }

            if (!mustStop) {
                // We remove the message at the tail of the queue
                val message = pendingMessages.removeLast()
                // We already ensured that it is a local actor ref in sendMessage()
                val target = message.target as LocalActorRef

                val mailbox = mailboxes[target]
                    ?: throw NoMailboxRegisteredForMessageTargetException(target)

                mailbox.postMessage(message)
            }
        }
    }
}

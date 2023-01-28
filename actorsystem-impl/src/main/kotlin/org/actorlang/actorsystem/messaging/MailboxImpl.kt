package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.Actor
import org.actorlang.actorsystem.ActorSystem
import java.util.Optional
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.collections.ArrayDeque
import kotlin.concurrent.withLock

class MailboxImpl(
    private val actorSystem: ActorSystem,
    private val actor: Actor
) : Mailbox {
    private val lock = ReentrantLock()
    private val messageAvailableCondition = lock.newCondition()
    private val messages = ArrayDeque<Message>()

    override fun postMessage(message: Message) = lock.withLock {
        if (actorSystem.isActorAlive(actor)) {
            messages.addLast(message)

            if (!actorSystem.actorAwakener.isActorAwake(actor)) {
                actorSystem.actorAwakener.wakeActorUp(actor)
            } else {
                messageAvailableCondition.signal()
            }
        }
    }

    override fun tryGetMessage(timeoutMillis: Long): Optional<Message> = lock.withLock {
        if (messages.isNotEmpty() || messageAvailableCondition.await(timeoutMillis, TimeUnit.MILLISECONDS)) {
            Optional.of(messages.removeLast())
        } else {
            Optional.empty()
        }
    }
}

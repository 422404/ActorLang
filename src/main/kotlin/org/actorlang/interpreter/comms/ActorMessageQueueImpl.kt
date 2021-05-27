package org.actorlang.interpreter.comms

import java.util.LinkedList
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ActorMessageQueueImpl: ActorMessageQueue {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()

    private val messages = LinkedList<Message>()

    override val size: Int
        get() = lock.withLock {
            messages.size
        }

    override fun push(message: Message) = lock.withLock {
        messages.push(message)
        condition.signal()
    }


    override fun pushRandomIndex(message: Message) = lock.withLock {
        messages.add((0..messages.size).random(), message)
        condition.signal()
    }

    override fun pull(timeoutMillis: Long): Message? = lock.withLock {
        if (messages.isEmpty()) {
            val success = condition.await(timeoutMillis, TimeUnit.MILLISECONDS)
            if (!success) {
                return null
            }
        }
        return messages.pop()
    }
}

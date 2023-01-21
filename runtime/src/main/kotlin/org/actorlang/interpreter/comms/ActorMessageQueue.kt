package org.actorlang.interpreter.comms

interface ActorMessageQueue {
    val size: Int
    fun push(message: Message)
    fun pushRandomIndex(message: Message)
    fun pull(timeoutMillis: Long): Message?
}

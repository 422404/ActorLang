package org.actorlang.interpreter.synchronization

import org.actorlang.actorsystem.messaging.LocalMessagingServer
import org.actorlang.actorsystem.messaging.NetworkAwareMessagingServer

/**
 * When using a [LocalMessagingServer] we can assume that the program has finished executing
 * when all actor threads have finished executing.
 * When using a [NetworkAwareMessagingServer] we cannot assume that program has finished so
 * we must wait for an actor to explicitly terminate the program.
 */
interface InterpreterSynchronization {
    /**
     * The reason of the interpreter exit. Can be null if the interpreter not yet exited.
     */
    val exitReason: InterpreterExitReason?

    /**
     * Blocks the thread until an exit condition is met.
     */
    fun waitForExitCondition()
}

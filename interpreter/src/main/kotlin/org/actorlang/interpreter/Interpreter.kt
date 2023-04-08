package org.actorlang.interpreter

import org.actorlang.actorsystem.ServerLike
import org.actorlang.interpreter.synchronization.InterpreterExitReason

interface Interpreter : ServerLike {
    companion object {
        const val SHUTDOWN_TIMEOUT_MS = 100L
    }

    /**
     * Runs the given actorlang code.
     * @param source The actorlang code to run
     * @param sourceName The name of the source (e.g. filename)
     * @return The reason of the exit (normal or erroneous)
     */
    fun run(source: String, sourceName: String): InterpreterExitReason
}

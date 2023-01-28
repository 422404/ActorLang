package org.actorlang.interpreter.synchronization.impl

import org.actorlang.interpreter.synchronization.InterpreterExitReason

/**
 * All local actor threads timed out. This is a suitable exit condition for a non-networked interpreter to exit.
 */
object AllLocalActorThreadsTimedOutExitReason : InterpreterExitReason

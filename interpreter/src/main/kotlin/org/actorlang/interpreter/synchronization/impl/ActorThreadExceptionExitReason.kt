package org.actorlang.interpreter.synchronization.impl

import org.actorlang.interpreter.synchronization.InterpreterExitReason

/**
 * An exception was thrown during the handling of a message by an actor thread.
 * This is a suitable exit condition for an interpreter.
 */
class ActorThreadExceptionExitReason(val exception: Throwable) : InterpreterExitReason

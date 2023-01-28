package org.actorlang.actorsystem.events

/**
 * Notifies that an exception was thrown during the handling of a message by an actor thread.
 * @param exception The exception that was thrown
 */
class ActorThreadExceptionEvent(val exception: Throwable) : Event

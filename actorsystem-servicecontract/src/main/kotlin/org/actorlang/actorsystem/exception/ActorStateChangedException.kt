package org.actorlang.actorsystem.exception

import org.actorlang.actorsystem.ActorState

/**
 * A special exception thrown by an actor when it changes its state and needs to
 * stop further processing of a received message.
 *
 * See [ActorState.become].
 */
class ActorStateChangedException : ActorSystemRuntimeException()

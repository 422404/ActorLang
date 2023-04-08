package org.actorlang.actorsystem

import org.actorlang.actorsystem.messaging.LocalActorRef

/**
 * Represents an actor in the actor system.
 * @param ref The actor local reference in the messaging server
 */
data class Actor(val ref: LocalActorRef)

package org.actorlang.actorsystem.messaging

import java.util.UUID

/**
 * Represents a reference to an actor in the local actor system.
 * @param actorId A unique identifier to differentiate the actor in the local actor system
 */
data class LocalActorRef(
    val actorId: UUID
) : ActorRef

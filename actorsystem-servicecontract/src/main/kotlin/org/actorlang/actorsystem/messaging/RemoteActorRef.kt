package org.actorlang.actorsystem.messaging

import java.io.Serializable
import java.util.UUID

/**
 * Represents a reference to an actor in a remote actor system.
 * @param host The host string (IP address or host name) of the remote messaging server
 * @param port The port of the remote messaging server
 * @param actorId A unique identifier to differentiate the actor in the remote actor system
 */
data class RemoteActorRef(
    val host: String,
    val port: Int,
    val actorId: UUID
) : ActorRef, Serializable

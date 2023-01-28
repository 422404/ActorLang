package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.exception.DoesNotReferenceALocalActorException

/**
 * A messaging server that accepts connections from clients (i.e. other messaging servers in other processes,
 * possibly running on other machines).
 */
interface NetworkAwareMessagingServer : MessagingServer {
    /**
     * The host (IP address or host name) used by external connections.
     */
    val host: String

    /**
     * The port used by external connections.
     */
    val port: Int

    /**
     * Checks whether a remote actor ref is referencing a local actor.
     * @param remoteActorRef The remote actor ref
     * @return True if that is the case, false if not
     */
    fun isLocalActorRef(remoteActorRef: RemoteActorRef): Boolean

    /**
     * Translates a remote actor ref to a local actor ref.
     * @param remoteActorRef The remote actor ref
     * @return The translated local actor ref
     * @throws DoesNotReferenceALocalActorException
     */
    fun toLocalActorRef(remoteActorRef: RemoteActorRef): LocalActorRef

    /**
     * Translates a local actor ref to a remote actor ref.
     * @param localActorRef The local actor ref
     * @return The translated remote actor ref
     */
    fun toRemoteActorRef(localActorRef: LocalActorRef): RemoteActorRef
}

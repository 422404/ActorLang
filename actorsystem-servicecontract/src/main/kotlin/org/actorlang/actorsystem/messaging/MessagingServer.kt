package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.ServerLike
import java.util.Optional

/**
 * A local (in-process) messaging server.
 */
interface MessagingServer : ServerLike {
    /**
     * Send a message to a target actor.
     * @param message The message to send
     */
    fun sendMessage(message: Message)

    /**
     * Tries to retrieve a message from an actor registered mailbox.
     * @param actorRef The actor reference
     * @param timeoutMillis The timeout in milliseconds after which this method returns an empty optional
     * @return An optional with a message if there was one in the mailbox or an empty optional if not
     */
    fun tryGetMessage(actorRef: LocalActorRef, timeoutMillis: Long): Optional<Message>

    /**
     * Registers a mailbox for a given local actor reference.
     * @param actorRef The local actor reference
     * @param mailbox The mailbox
     */
    fun registerMailbox(actorRef: LocalActorRef, mailbox: Mailbox)

    /**
     * Unregisters a mailbox for a local actor reference.
     * @param actorRef The local actor reference for which we want to unregister the mailbox
     */
    fun unregisterMailbox(actorRef: LocalActorRef)
}

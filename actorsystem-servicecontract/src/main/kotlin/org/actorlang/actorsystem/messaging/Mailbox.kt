package org.actorlang.actorsystem.messaging

import java.util.Optional

interface Mailbox {
    /**
     * Posts a message into the mailbox.
     */
    fun postMessage(message: Message)

    /**
     * Tries to retrieve a message from the mailbox.
     * @param timeoutMillis The timeout in milliseconds after which this method returns an empty optional
     * @return An optional with a message if there was one in the mailbox or an empty optional if not
     */
    fun tryGetMessage(timeoutMillis: Long): Optional<Message>
}

package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.messaging.exception.NoMailboxRegisteredForActorRefException
import org.actorlang.actorsystem.messaging.exception.NonLocalActorRefException
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.util.Optional
import java.util.UUID
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertSame
import kotlin.test.assertTrue

private const val SHUTDOWN_TIMEOUT_MS = 10L

class LocalMessagingServerTest {
    private lateinit var messagingServer: MessagingServer

    @BeforeTest
    fun setup() {
        messagingServer = LocalMessagingServer()
        messagingServer.start()
    }

    @AfterTest
    fun teardown() {
        messagingServer.shutdown(SHUTDOWN_TIMEOUT_MS)
    }

    @Test
    fun `We can register a mailbox`() {
        val mailbox = mock<Mailbox>()
        val actorRef = LocalActorRef(UUID.randomUUID())

        messagingServer.registerMailbox(actorRef, mailbox)
    }

    @Test
    fun `We can unregister a mailbox`() {
        val mailbox = mock<Mailbox>()
        val actorRef = LocalActorRef(UUID.randomUUID())

        messagingServer.registerMailbox(actorRef, mailbox)
        messagingServer.unregisterMailbox(actorRef)
    }

    @Test
    fun `Non-local actor refs cannot be used as target of a message`() {
        val actorRef = mock<ActorRef>()
        val message = object : Message(actorRef) {}

        assertFailsWith<NonLocalActorRefException> {
            messagingServer.sendMessage(message)
        }
    }

    @Test
    fun `An exception is thrown when trying to pull a message for an unknown actor ref`() {
        val actorRef = LocalActorRef(UUID.randomUUID())

        assertFailsWith<NoMailboxRegisteredForActorRefException> {
            messagingServer.tryGetMessage(actorRef, 1L)
        }
    }

    @Test
    fun `We can pull a message that is present in a known actor mailbox`() {
        val actorRef = LocalActorRef(UUID.randomUUID())
        val message = object : Message(actorRef) {}
        val mailbox = mock<Mailbox> {
            on { tryGetMessage(any()) } doReturn Optional.of(message)
        }

        messagingServer.registerMailbox(actorRef, mailbox)
        val returnedMessage = messagingServer.tryGetMessage(actorRef, 1L)
        assertTrue(returnedMessage.isPresent)
        assertSame(message, returnedMessage.get())
    }

    @Test
    fun `When a message is posted, it is dispatched to the target mailbox`() {
        val actorRef = LocalActorRef(UUID.randomUUID())
        val mailbox = mock<Mailbox>()
        val message = object : Message(actorRef) {}

        messagingServer.registerMailbox(actorRef, mailbox)
        messagingServer.sendMessage(message)
        // We cannot properly synchronize ourselves then we must use sleep which is not great but should work
        Thread.sleep(10L)
        verify(mailbox).postMessage(message)
    }

    @Test
    fun `When a message is posted for an unknown actor ref, it is dropped`() {
        val actorRef = LocalActorRef(UUID.randomUUID())
        val message = object : Message(actorRef) {}

        messagingServer.sendMessage(message)
    }
}

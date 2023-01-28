package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener
import org.actorlang.actorsystem.exception.ActorStateChangedException
import org.actorlang.actorsystem.messaging.Message
import org.actorlang.actorsystem.messaging.MessagingServer
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.util.Optional
import kotlin.test.BeforeTest
import kotlin.test.Test

class ActorThreadImplTest {
    private lateinit var actor: Actor
    private val actorFactory = ActorFactoryImpl()

    @BeforeTest
    fun setup() {
        actor = actorFactory.createActor()
    }

    @Test
    fun `When a message is received then we let the actor type instance handle it`() {
        val message = mock<Message>()
        val mockedMessagingServer = mock<MessagingServer> {
            on { tryGetMessage(any(), any()) } doReturn Optional.of(message)
        }
        val actorState = mock<ActorState>()
        val actorSystem = mock<ActorSystem> {
            on { messagingServer } doReturn mockedMessagingServer
            on { getActorState(any()) } doReturn actorState
            // We do it so the actor thread does only one iteration of its loop
            on { isActorAlive(any()) } doReturn false
        }
        val actorThreadEventListener = mock<ActorThreadEventListener>()
        val actorThread = ActorThreadImpl(actor, 1000L, actorSystem, actorThreadEventListener)

        val thread = Thread(actorThread)
        thread.start()
        thread.join()
        verify(actorState).handleMessage(message)
        verify(actorThreadEventListener).onActorThreadExit(actor)
    }

    @Test
    fun `When we timeout while trying to get a message, we stop to not waste system resources`() {
        val mockedMessagingServer = mock<MessagingServer> {
            on { tryGetMessage(any(), any()) } doReturn Optional.empty()
        }
        val actorSystem = mock<ActorSystem> {
            on { messagingServer } doReturn mockedMessagingServer
        }
        val actorThreadEventListener = mock<ActorThreadEventListener>()
        val actorThread = ActorThreadImpl(actor, 1000L, actorSystem, actorThreadEventListener)

        val thread = Thread(actorThread)
        thread.start()
        thread.join()
        verify(actorThreadEventListener).onActorThreadExit(actor)
    }

    @Test
    fun `Exceptions are properly caught when handling messages`() {
        val message1 = mock<Message>()
        val message2 = mock<Message>()
        // The last optional is empty so that the actor thread exits its loop
        val messages = arrayOf(Optional.of(message1), Optional.of(message2), Optional.empty())
        var index = 0

        val mockedMessagingServer = mock<MessagingServer> {
            on { tryGetMessage(any(), any()) } doAnswer {
                messages[index++]
            }
        }
        val actorState = mock<ActorState> {
            on { handleMessage(message1) } doAnswer {
                throw ActorStateChangedException()
            }

            on { handleMessage(message2) } doAnswer {
                throw NullPointerException()
            }
        }
        val actorSystem = mock<ActorSystem> {
            on { messagingServer } doReturn mockedMessagingServer
            on { getActorState(any()) } doReturn actorState
            // We do it so that we can handle multiple messages
            on { isActorAlive(any()) } doReturn true
        }
        val actorThreadEventListener = mock<ActorThreadEventListener>()
        val actorThread = ActorThreadImpl(actor, 1000L, actorSystem, actorThreadEventListener)

        val thread = Thread(actorThread)
        thread.start()
        thread.join()
        verify(actorState).handleMessage(message1)
        verify(actorState).handleMessage(message2)
        verify(actorThreadEventListener).onActorThreadExit(actor)
    }
}

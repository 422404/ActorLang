package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener
import org.actorlang.actorsystem.exception.ActorNotRegisteredInActorSystem
import org.actorlang.actorsystem.messaging.MailboxFactory
import org.mockito.internal.verification.Times
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy
import org.mockito.kotlin.verify
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

private const val SHUTDOWN_TIMEOUT_MS = 10L

class ActorSystemImplAdvancedTest {
    private val actorFactory = ActorFactoryImpl()

    private fun mockedActorThreadFactory(actorThreadLock: ReentrantLock): ActorThreadFactory {
        return mock {
            on { createActorThread(any(), any(), any()) } doAnswer { actorThreadFactoryInvocation ->
                mock {
                    on { run() } doAnswer {
                        val actorThreadEventListener = actorThreadFactoryInvocation.arguments[2] as ActorThreadEventListener
                        val actorArg = actorThreadFactoryInvocation.arguments[0] as Actor
                        actorThreadLock.lock() // Make the actor thread wait
                        actorThreadEventListener.onActorThreadExit(actorArg)
                    }
                }
            }
        }
    }

    @Test
    fun `We can wake up an actor that is just registered`() {
        val actorThreadFactory = mock<ActorThreadFactory> {
            on { createActorThread(any(), any(), any()) } doReturn mock()
        }
        val actorSystem = ActorSystemImpl(mock(), mock(), actorThreadFactory, mock(), mock())
        val actor = actorFactory.createActor()

        actorSystem.start()
        actorSystem.registerActor(actor)
        actorSystem.actorAwakener.wakeActorUp(actor)
        verify(actorThreadFactory).createActorThread(eq(actor), any(), any())
        actorSystem.shutdown(SHUTDOWN_TIMEOUT_MS)
    }

    @Test
    fun `We cannot wake up an unregistered or dead actor`() {
        val actorThreadFactory = mock<ActorThreadFactory>()
        val actorSystem = ActorSystemImpl(mock(), mock(), actorThreadFactory, mock(), mock())
        val actor = actorFactory.createActor()

        actorSystem.start()
        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.actorAwakener.wakeActorUp(actor)
        }
        actorSystem.shutdown(SHUTDOWN_TIMEOUT_MS)
    }

    @Test
    fun `We don't wake up an actor that is already woke up`() {
        // We use a lock to guarantee that the mocked actor thread will be running
        // as long as we hold the lock
        val lock = ReentrantLock()
        val actorThreadFactory = mockedActorThreadFactory(lock)
        val actorSystem = ActorSystemImpl(mock(), mock(), actorThreadFactory, mock(), mock())
        val actor = actorFactory.createActor()

        actorSystem.start()
        // We lock the lock so that the mocked actor thread will only terminate
        // after the second call to wakeActorUp()
        lock.withLock {
            actorSystem.registerActor(actor)
            actorSystem.actorAwakener.wakeActorUp(actor)
            actorSystem.actorAwakener.wakeActorUp(actor)
            verify(actorThreadFactory, Times(1)).createActorThread(actor, actorSystem, actorSystem)
        }
        actorSystem.shutdown(SHUTDOWN_TIMEOUT_MS)
    }

    @Test
    fun `createActorWithState() creates an actor, registers it, binds it to the provided state, registers a mailbox and wakes it up`() {
        // We use a lock to guarantee that the mocked actor thread will be running
        // as long as we hold the lock
        val lock = ReentrantLock()
        val actorThreadFactory = mockedActorThreadFactory(lock)
        val actorFactory = spy(ActorFactoryImpl())
        val mailboxFactory = mock<MailboxFactory> {
            on { createMailbox(any(), any()) } doReturn mock()
        }
        val actorSystem = ActorSystemImpl(mock(), actorFactory, actorThreadFactory, mailboxFactory, mock())
        val actorState = mock<ActorState>()

        actorSystem.start()
        // We lock the lock so that the mocked actor thread will only terminate
        // when we have finished the test
        lock.withLock {
            val actor = actorSystem.createActorWithState(actorState)
            verify(actorFactory).createActor()
            verify(mailboxFactory).createMailbox(actorSystem, actor)
            verify(actorSystem.messagingServer).registerMailbox(eq(actor.ref), any())
            assertTrue(actorSystem.isActorAlive(actor))
            assertEquals(actorState, actorSystem.getActorState(actor))
            assertTrue(actorSystem.actorAwakener.isActorAwake(actor))
        }
        actorSystem.shutdown(SHUTDOWN_TIMEOUT_MS)
    }
}

package org.actorlang.actorsystem.messaging

import org.actorlang.actorsystem.Actor
import org.actorlang.actorsystem.ActorAwakener
import org.actorlang.actorsystem.ActorFactoryImpl
import org.actorlang.actorsystem.ActorSystem
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertSame
import kotlin.test.assertTrue

class MailboxImplTest {
    private lateinit var actor: Actor
    private val actorFactory = ActorFactoryImpl()

    @BeforeTest
    fun setup() {
        actor = actorFactory.createActor()
    }

    @Test
    fun `Check if the actor is alive before posting a message`() {
        val actorSystem = mock<ActorSystem> {
            on { isActorAlive(any()) } doReturn false
        }
        val mailbox = MailboxImpl(actorSystem, actor)

        mailbox.postMessage(mock())
        verify(actorSystem).isActorAlive(actor)
    }

    @Test
    fun `If the actor thread is waiting for messages, we signal it after posting one`() {
        val threadStartedLock = ReentrantLock()
        val threadStartedCondition = threadStartedLock.newCondition()
        var threadStarted = false

        val mockedActorAwakener = mock<ActorAwakener> {
            on { isActorAwake(any()) } doReturn true
        }
        val actorSystem = mock<ActorSystem> {
            on { isActorAlive(any()) } doReturn true
            on { actorAwakener } doReturn mockedActorAwakener
        }
        val mailbox = MailboxImpl(actorSystem, actor)
        var gotMessage = false
        val actorThread = Thread {
            threadStartedLock.withLock {
                threadStarted = true
                threadStartedCondition.signal()
            }
            val message = mailbox.tryGetMessage(10000L)
            if (message.isPresent) {
                gotMessage = true
            }
        }

        actorThread.start()
        threadStartedLock.withLock {
            if (!threadStarted) {
                threadStartedCondition.await()
            }
        }
        Thread.sleep(10L)
        mailbox.postMessage(mock())
        actorThread.join()

        assertTrue(gotMessage)
        verify(mockedActorAwakener, never()).wakeActorUp(any())
    }

    @Test
    fun `If the actor is not awake, we wake it up`() {
        val mockedActorAwakener = mock<ActorAwakener> {
            on { isActorAwake(any()) } doReturn false
        }
        val actorSystem = mock<ActorSystem> {
            on { isActorAlive(any()) } doReturn true
            on { actorAwakener } doReturn mockedActorAwakener
        }
        val mailbox = MailboxImpl(actorSystem, actor)

        mailbox.postMessage(mock())
        verify(mockedActorAwakener).wakeActorUp(actor)
    }

    @Test
    fun `If no message is posted before the timeout occurs then no message is returned`() {
        val mailbox = MailboxImpl(mock(), actor)

        val message = mailbox.tryGetMessage(1L)
        assertFalse(message.isPresent)
    }

    @Test
    fun `If a message is already present then it is directly returned`() {
        val mockedActorAwakener = mock<ActorAwakener> {
            on { isActorAwake(any()) } doReturn true
        }
        val actorSystem = mock<ActorSystem> {
            on { isActorAlive(any()) } doReturn true
            on { actorAwakener } doReturn mockedActorAwakener
        }
        val mailbox = MailboxImpl(actorSystem, actor)
        val message = mock<Message>()

        mailbox.postMessage(message)
        val returnedMessage = mailbox.tryGetMessage(10000L)
        assertTrue(returnedMessage.isPresent)
        assertSame(message, returnedMessage.get())
    }
}

package org.actorlang.interpreter.scheduler

import org.actorlang.config.Configuration
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.comms.ActorMessageQueue
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.objects.Actor
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ActorThreadImplTest {
    @Test
    fun `Do not receive message when pull timeouts`() {
        val lock = ReentrantLock()
        val condition = lock.newCondition()
        var done = false

        val actorMock = mock<Actor>()
        val actorMessageQueueMock = mock<ActorMessageQueue> {
            on {
                pull(any())
            } doAnswer {
                lock.withLock {
                    done = true
                    condition.signal()
                }
                null
            }
        }
        val contextMock = mock<Context> {
            on {
                configuration
            } doAnswer {
                Configuration().apply {
                    messageLatencyMaxMillis = 1L
                }
            }

            on {
                schedulerSynchronization
            } doAnswer {
                mock<SchedulerSynchronization>()
            }
        }
        val actorThread = ActorThreadImpl(actorMock, actorMessageQueueMock, contextMock)
        actorThread.start()
        lock.withLock {
            if (!done) {
                condition.await()
            }
        }
        actorThread.stopWhenPermitted()
        actorThread.join()
        verify(actorMock, never()).receive(any())
    }

    @Test
    fun `Messages are received`() {
        val lock = ReentrantLock()
        val condition = lock.newCondition()
        var done = false
        val messageCount = 3
        var pullCount = 0

        val message = Message(arrayOf())
        val actorMock = mock<Actor>()
        val actorMessageQueueMock = mock<ActorMessageQueue> {
            on {
                pull(any())
            } doAnswer {
                var returnedMessage: Message? = message
                lock.withLock {
                    pullCount++
                    if (pullCount > messageCount) {
                        condition.signal()
                        done = true
                        returnedMessage = null
                    }
                }
                returnedMessage
            }
        }
        val schedulerSynchronizationMock = mock<SchedulerSynchronization>() {
            on { execeptionThrown(any(), any()) } doAnswer {
                throw it.arguments[1] as Exception
            }
        }
        val contextMock = mock<Context> {
            on {
                configuration
            } doAnswer {
                Configuration().apply {
                    messageLatencyMaxMillis = 1L
                }
            }

            on {
                schedulerSynchronization
            } doReturn schedulerSynchronizationMock
        }
        val actorThread = ActorThreadImpl(actorMock, actorMessageQueueMock, contextMock)
        actorThread.start()
        lock.withLock {
            if (!done) {
                condition.await()
            }
        }
        actorThread.stopWhenPermitted()
        actorThread.join()
        verify(actorMock, times(messageCount)).receive(any())
    }
}

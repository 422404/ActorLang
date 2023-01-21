package org.actorlang.interpreter.scheduler

import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.concurrent.thread

class SchedulerImplTest {
    @Test
    fun `Starts all scheduled threads`() {
        val scheduler = SchedulerImpl()
        val actorThreadMock = mock<ActorThread>()
        scheduler.schedule(actorThreadMock)
        verify(actorThreadMock).start()
    }

    @Test
    fun `Join all scheduled threads when they are all idle`() {
        val scheduler = SchedulerImpl()
        val actorThreadMocks = Array(3) {
            mock<ActorThread>() {
                on { state } doReturn(ActorThreadState.TIMEOUT)
            }
        }
        actorThreadMocks.forEach { scheduler.schedule(it) }
        thread {
            Thread.sleep(10) // We want Scheduler#join to be called before
            actorThreadMocks.forEach {
                scheduler.pullTimeout(it)
            }
        }
        scheduler.join()
        actorThreadMocks.forEach {
            verify(it).stopWhenPermitted()
            verify(it).join()
        }
    }
}

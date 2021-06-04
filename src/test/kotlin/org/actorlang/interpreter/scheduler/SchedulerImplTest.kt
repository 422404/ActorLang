package org.actorlang.interpreter.scheduler

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SchedulerImplTest {
    @Test
    fun `Starts all scheduled threads`() {
        val scheduler = SchedulerImpl()
        val actorThreadMock = mock<ActorThread>()
        scheduler.schedule(actorThreadMock)
        verify(actorThreadMock).start()
    }

    @Test
    fun `Join all scheduled threads`() {
        val scheduler = SchedulerImpl()
        val actorThreadMocks = Array(3) { mock<ActorThread>() }
        actorThreadMocks.forEach { scheduler.schedule(it) }
        scheduler.join()
        actorThreadMocks.forEach {
            verify(it).stopWhenPermitted()
            verify(it).join()
        }
    }
}

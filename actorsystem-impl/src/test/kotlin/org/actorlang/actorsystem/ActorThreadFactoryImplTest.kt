package org.actorlang.actorsystem

import org.mockito.kotlin.mock
import kotlin.test.Test
import kotlin.test.assertNotNull

class ActorThreadFactoryImplTest {
    @Test
    fun `Can create an actor thread`() {
        val actorThreadFactory = ActorThreadFactoryImpl(0L)
        val actorThread = actorThreadFactory.createActorThread(mock(), mock(), mock())
        assertNotNull(actorThread)
    }
}

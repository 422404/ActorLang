package org.actorlang.actorsystem

import kotlin.test.Test
import kotlin.test.assertNotEquals

class ActorFactoryImplTest {
    @Test
    fun `The actor factory creates actors with different local refs`() {
        val actorFactory = ActorFactoryImpl()
        val actor1 = actorFactory.createActor()
        val actor2 = actorFactory.createActor()

        assertNotEquals(actor1.ref, actor2.ref)
    }
}

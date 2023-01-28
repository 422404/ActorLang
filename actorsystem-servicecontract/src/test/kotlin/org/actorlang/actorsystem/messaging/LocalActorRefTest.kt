package org.actorlang.actorsystem.messaging

import org.mockito.kotlin.spy
import org.mockito.kotlin.verify
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertNotEquals

class LocalActorRefTest {
    @Test
    @Suppress("UnusedEquals")
    fun `Comparing local actor refs compares the UUIDs`() {
        val actorRef1 = LocalActorRef(UUID.randomUUID())
        val actorRef2 = LocalActorRef(spy(UUID.randomUUID()))

        assertNotEquals(actorRef1, actorRef2)
        verify(actorRef2.actorId) == actorRef1.actorId
    }
}

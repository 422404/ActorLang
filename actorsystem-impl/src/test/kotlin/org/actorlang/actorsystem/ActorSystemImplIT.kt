package org.actorlang.actorsystem

import org.actorlang.actorsystem.messaging.LocalMessagingServer
import org.actorlang.actorsystem.messaging.MailboxFactoryImpl
import org.actorlang.actorsystem.messaging.Message
import org.actorlang.actorsystem.messaging.PoisonPill
import org.mockito.kotlin.mock
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ActorSystemImplIT {

    @Test
    fun `An actor receiving a PoisonPill message dies`() {
        val actorSystem = ActorSystemImpl(
            LocalMessagingServer(),
            ActorFactoryImpl(),
            ActorThreadFactoryImpl(1000L),
            MailboxFactoryImpl(),
            mock()
        )

        // A minimal actor state that only handle default messages
        val actorState = object : AbstractActorState(actorSystem) {
            override fun handleMessage(message: Message) {
                handleMessageDefault(message)
            }
        }

        actorSystem.scoped(100L) {
            // We create the actor
            val actor = createActorWithState(actorState)
            // The actor starts alive
            assertTrue(isActorAlive(actor))
            // We send a PoisonPill message to kill the actor
            messagingServer.sendMessage(PoisonPill(actor.ref))
            // Poor man synchronization, but it should always work
            Thread.sleep(100L)
            // The actor should be dead now
            assertFalse(isActorAlive(actor))
        }
    }
}

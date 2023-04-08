package org.actorlang.actorsystem

import org.actorlang.actorsystem.exception.ActorAlreadyRegisteredInActorSystem
import org.actorlang.actorsystem.exception.ActorNotRegisteredInActorSystem
import org.actorlang.actorsystem.exception.NoActorStateException
import org.mockito.kotlin.mock
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

private const val SHUTDOWN_TIMEOUT_MS = 10L

class ActorSystemImplSimpleTest {
    private lateinit var actorSystem: ActorSystem
    private lateinit var actor: Actor
    private val actorFactory = ActorFactoryImpl()

    @BeforeTest
    fun setup() {
        actorSystem = ActorSystemImpl(mock(), mock(), mock(), mock(), mock())
        actorSystem.start()
        actor = actorFactory.createActor()
    }

    @AfterTest
    fun teardown() {
        actorSystem.shutdown(SHUTDOWN_TIMEOUT_MS)
    }

    @Test
    fun `We can obtain the messaging server of an actor system`() {
        val messagingServer = actorSystem.messagingServer
        assertNotNull(messagingServer)
    }

    @Test
    fun `Cannot register the same actor twice`() {
        actorSystem.registerActor(actor)
        assertFailsWith<ActorAlreadyRegisteredInActorSystem> {
            actorSystem.registerActor(actor)
        }
    }

    @Test
    fun `We can bind an actor to an actor type`() {
        val actorState = mock<ActorState>()

        actorSystem.registerActor(actor)
        actorSystem.bindActorToNewActorState(actor, actorState)
    }

    @Test
    fun `We cannot bind an unregistered actor to an actor state`() {
        val actorState = mock<ActorState>()

        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.bindActorToNewActorState(actor, actorState)
        }
    }

    @Test
    fun `We can query the state of an actor`() {
        val actorState = mock<ActorState>()

        actorSystem.registerActor(actor)
        actorSystem.bindActorToNewActorState(actor, actorState)
        assertEquals(actorState, actorSystem.getActorState(actor))
    }

    @Test
    fun `We cannot query the state of an unregistered actor`() {
        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.getActorState(actor)
        }
    }

    @Test
    fun `We cannot query the state of an actor that has no bound type`() {
        actorSystem.registerActor(actor)
        assertFailsWith<NoActorStateException> {
            actorSystem.getActorState(actor)
        }
    }

    @Test
    fun `An actor that is registered starts alive`() {
        actorSystem.registerActor(actor)
        assertTrue(actorSystem.isActorAlive(actor))
    }

    @Test
    fun `An actor that is not registered is not alive`() {
        assertFalse(actorSystem.isActorAlive(actor))
    }

    @Test
    fun `A registered actor can be killed`() {
        actorSystem.registerActor(actor)
        actorSystem.killActor(actor)
        assertFalse(actorSystem.isActorAlive(actor))
    }

    @Test
    fun `An unregistered actor cannot be killed`() {
        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.killActor(actor)
        }
    }

    @Test
    fun `Cannot kill an actor twice`() {
        actorSystem.registerActor(actor)
        actorSystem.killActor(actor)
        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.killActor(actor)
        }
    }

    @Test
    fun `We cannot check if an unregistered actor is awake`() {
        assertFailsWith<ActorNotRegisteredInActorSystem> {
            actorSystem.actorAwakener.isActorAwake(actor)
        }
    }
}

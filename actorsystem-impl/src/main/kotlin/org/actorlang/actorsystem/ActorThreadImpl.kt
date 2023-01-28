package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener
import org.actorlang.actorsystem.exception.ActorStateChangedException
import org.actorlang.actorsystem.messaging.Message

class ActorThreadImpl(
    private val actor: Actor,
    private val idleTimeout: Long,
    private val actorSystem: ActorSystem,
    private val actorThreadEventListener: ActorThreadEventListener
) : ActorThread {

    override fun run() {
        var loop = true

        while (loop) {
            val message = actorSystem.messagingServer.tryGetMessage(actor.ref, idleTimeout)

            if (message.isPresent) {
                val actorState = actorSystem.getActorState(actor)
                handleMessage(message.get(), actorState)
            }

            if (!message.isPresent || !actorSystem.isActorAlive(actor)) {
                loop = false
            }
        }

        actorThreadEventListener.onActorThreadExit(actor)
    }

    private fun handleMessage(message: Message, actorState: ActorState) {
        try {
            actorState.handleMessage(message)
        } catch (e: ActorStateChangedException) {
            // We ignore it has it is made to short circuit the call stack
        } catch (e: Exception) {
            actorThreadEventListener.onActorThreadException(e)
        }
    }
}

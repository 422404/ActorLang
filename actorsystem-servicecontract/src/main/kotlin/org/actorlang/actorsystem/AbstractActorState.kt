package org.actorlang.actorsystem

import org.actorlang.actorsystem.exception.ActorStateChangedException
import org.actorlang.actorsystem.messaging.Message
import org.actorlang.actorsystem.messaging.PoisonPill

/**
 * The class from which actor types must be implemented.
 * It contains the implementation of the [become] method.
 * @param actorSystem The actor system
 */
abstract class AbstractActorState(
    protected val actorSystem: ActorSystem
) : ActorState {
    lateinit var actor: Actor
        private set

    /**
     * Implements the default handling of special messages.
     * You may call it at the end of the user-defined
     * message handling method.
     * This method handles killing an actor and unregistering its mailbox upon receiving a [PoisonPill] message.
     * @param message The message to handle
     */
    fun handleMessageDefault(message: Message) {
        if (message is PoisonPill) {
            actorSystem.killActor(actor)
            actorSystem.messagingServer.unregisterMailbox(actor.ref)
        }
    }

    final override fun become(newActorState: ActorState): Nothing {
        actorSystem.bindActorToNewActorState(actor, newActorState)
        throw ActorStateChangedException()
    }

    final override fun onBind(actor: Actor) {
        this.actor = actor
    }
}

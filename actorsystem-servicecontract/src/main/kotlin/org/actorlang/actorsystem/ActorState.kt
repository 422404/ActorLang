package org.actorlang.actorsystem

import org.actorlang.actorsystem.exception.ActorStateChangedException
import org.actorlang.actorsystem.messaging.Message

sealed interface ActorState {
    /**
     * Handles a received message.
     * @param message The received message
     * @throws ActorStateChangedException When the actor changes its state and stops
     *                                    further processing of the current message
     */
    fun handleMessage(message: Message)

    /**
     * Changes the actor current state and stops further processing of the current message.
     * It makes the control flow exit the [handleMessage] method immediately.
     * @param newActorState The new actor state
     * @throws ActorStateChangedException
     */
    fun become(newActorState: ActorState): Nothing

    /**
     * Called when the state is bound to an actor.
     */
    fun onBind(actor: Actor)
}

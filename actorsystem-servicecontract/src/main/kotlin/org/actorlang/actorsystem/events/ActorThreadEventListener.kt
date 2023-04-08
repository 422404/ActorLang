package org.actorlang.actorsystem.events

import org.actorlang.actorsystem.Actor

/**
 * Represents an object listening for events emitted by an actor thread.
 */
interface ActorThreadEventListener {
    /**
     * Must be called when an actor thread finish executing so that resources can be freed/reused.
     * @param actor The actor for which the thread runs
     */
    fun onActorThreadExit(actor: Actor)

    /**
     * Must be called when an actor thread catches an exception instead of logging it.
     * @param e An exception
     */
    fun onActorThreadException(e: Throwable)
}

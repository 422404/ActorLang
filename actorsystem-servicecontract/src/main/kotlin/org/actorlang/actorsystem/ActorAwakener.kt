package org.actorlang.actorsystem

import org.actorlang.actorsystem.exception.ActorNotRegisteredInActorSystem

interface ActorAwakener {
    /**
     * Checks whether a given actor thread is running and pumping messages.
     *
     * You must ensure that the actor is known to the actor system by calling [ActorSystem.isActorAlive].
     * @param actor The actor
     * @return true if the actor thread is running or false if not
     * @throws ActorNotRegisteredInActorSystem
     */
    fun isActorAwake(actor: Actor): Boolean

    /**
     * Runs the actor thread of the given actor.
     *
     * You must ensure that the actor is known to the actor system by calling [ActorSystem.isActorAlive].
     * @param actor The actor
     * @throws ActorNotRegisteredInActorSystem
     */
    fun wakeActorUp(actor: Actor)
}

package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener

interface ActorThreadFactory {
    fun createActorThread(
        actor: Actor,
        actorSystem: ActorSystem,
        actorThreadEventListener: ActorThreadEventListener
    ): ActorThread
}

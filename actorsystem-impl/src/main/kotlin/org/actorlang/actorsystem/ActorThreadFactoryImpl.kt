package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener

/**
 * @param idleTimeout The timeout after which this thread stops waiting for messages (in milliseconds)
 */
class ActorThreadFactoryImpl(
    private val idleTimeout: Long
) : ActorThreadFactory {

    override fun createActorThread(
        actor: Actor,
        actorSystem: ActorSystem,
        actorThreadEventListener: ActorThreadEventListener
    ): ActorThread {
        return ActorThreadImpl(actor, idleTimeout, actorSystem, actorThreadEventListener)
    }
}

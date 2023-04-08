package org.actorlang.actorsystem.registry

import org.actorlang.actorsystem.messaging.RemoteActorRef
import org.actorlang.actorsystem.registry.exception.ActorAlreadyRegistered
import org.actorlang.actorsystem.registry.exception.ActorNotRegistered
import org.actorlang.actorsystem.registry.exception.WrongActorRegistration

interface ActorRegistry {
    /**
     * Checks whether there is an actor in the registry that was registered with the given name.
     * @param actorName The actor name to check
     * @return true if an actor was registered with the given name or false if not
     */
    fun hasNamedActor(actorName: String): Boolean

    /**
     * Retrieves an actor by its name.
     * @param actorName The actor name
     * @throws ActorNotRegistered If no actor was registered with this name
     */
    fun getNamedActor(actorName: String): RemoteActorRef

    /**
     * Registers an actor with a given name.
     * @param actorName The actor name
     * @param actorRef The actor remote reference
     * @return The actor registration that must be used to unregister it
     * @throws ActorAlreadyRegistered If an actor is already registered with this name
     */
    fun registerNamedActor(actorName: String, actorRef: RemoteActorRef): ActorRegistration

    /**
     * Unregisters an actor.
     * @param actorRegistration The actor registration that was returned by [registerNamedActor]
     * @throws WrongActorRegistration When attempting the use an unknown actor registration
     */
    fun unregisterActor(actorRegistration: ActorRegistration)
}

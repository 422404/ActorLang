package org.actorlang.actorsystem

import org.actorlang.actorsystem.exception.ActorAlreadyRegisteredInActorSystem
import org.actorlang.actorsystem.exception.ActorNotRegisteredInActorSystem
import org.actorlang.actorsystem.messaging.MessagingServer
import org.actorlang.actorsystem.messaging.PoisonPill

interface ActorSystem : ServerLike {
    /**
     * Exposes some scheduling methods for the mailboxes.
     */
    val actorAwakener: ActorAwakener

    /**
     * The messaging server used by the actor system.
     */
    val messagingServer: MessagingServer

    /**
     * Registers the actor as an alive actor in the actor system.
     * @param actor The actor to register
     * @throws ActorAlreadyRegisteredInActorSystem
     */
    fun registerActor(actor: Actor)

    /**
     * Creates a new actor with a given state and binds a mailbox to it.
     * The actor is immediately scheduled.
     * @param actorState The initial state of the actor to schedule
     */
    fun createActorWithState(actorState: ActorState): Actor

    /**
     * Binds a new state to an existing actor.
     * @param actor The actor
     * @param newActorState The new type of the actor
     * @throws ActorNotRegisteredInActorSystem
     */
    fun bindActorToNewActorState(actor: Actor, newActorState: ActorState)

    /**
     * Retrieves the state of the given actor.
     * @param actor The actor
     * @return The actor state
     * @throws ActorNotRegisteredInActorSystem
     */
    fun getActorState(actor: Actor): ActorState

    /**
     * Checks whether the actor is alive.
     *
     * An alive actor is one satisfying these conditions:
     * - it has not received a [PoisonPill]
     * - [killActor] has never been called on it
     * - it has been registered with [registerActor]
     * @param actor The actor
     * @return true if the actor is alive or false if it is dead
     */
    fun isActorAlive(actor: Actor): Boolean

    /**
     * Kills a given actor (e.g. after is has received a [PoisonPill]).
     * @param actor The actor to kill
     * @throws ActorNotRegisteredInActorSystem
     */
    fun killActor(actor: Actor)
}

package org.actorlang.actorsystem.exception

import org.actorlang.actorsystem.Actor

class ActorAlreadyRegisteredInActorSystem(val actor: Actor) : ActorSystemRuntimeException(
    "The actor ${actor.ref} is already registered in the actor system"
)

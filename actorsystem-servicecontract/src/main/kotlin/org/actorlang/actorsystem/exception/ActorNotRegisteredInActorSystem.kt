package org.actorlang.actorsystem.exception

import org.actorlang.actorsystem.Actor

class ActorNotRegisteredInActorSystem(val actor: Actor) : ActorSystemRuntimeException(
    "The actor ${actor.ref} was not registered in the actor system"
)

package org.actorlang.actorsystem.exception

import org.actorlang.actorsystem.Actor

class NoActorStateException(actor: Actor) : ActorSystemRuntimeException(
    "The actor ${actor.ref} has no state"
)

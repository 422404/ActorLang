package org.actorlang.actorsystem.exception

import org.actorlang.actorsystem.messaging.RemoteActorRef

class DoesNotReferenceALocalActorException(actorRef: RemoteActorRef) : ActorSystemRuntimeException(
    "The actor ref $actorRef does not represent a known local actor"
)

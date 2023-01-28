package org.actorlang.actorsystem.messaging.exception

import org.actorlang.actorsystem.exception.ActorSystemRuntimeException

class NonLocalActorRefException : ActorSystemRuntimeException(
    "Non local actor reference used as the target of a message in a local messaging server"
)

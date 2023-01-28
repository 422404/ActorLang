package org.actorlang.actorsystem.messaging.exception

import org.actorlang.actorsystem.exception.ActorSystemRuntimeException
import org.actorlang.actorsystem.messaging.LocalActorRef

class NoMailboxRegisteredForActorRefException(actorRef: LocalActorRef) : ActorSystemRuntimeException(
    "There is no mailbox registered for local actor ref $actorRef"
)

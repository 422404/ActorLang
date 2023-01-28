package org.actorlang.actorsystem.messaging.exception

import org.actorlang.actorsystem.exception.ActorSystemRuntimeException
import org.actorlang.actorsystem.messaging.LocalActorRef

class NoMailboxRegisteredForMessageTargetException(actorRef: LocalActorRef) : ActorSystemRuntimeException(
    "No mailbox registered for message target $actorRef"
)

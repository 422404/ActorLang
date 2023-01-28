package org.actorlang.actorsystem

import org.actorlang.actorsystem.messaging.LocalActorRef
import java.util.UUID

class ActorFactoryImpl : ActorFactory {
    override fun createActor() = Actor(LocalActorRef(UUID.randomUUID()))
}

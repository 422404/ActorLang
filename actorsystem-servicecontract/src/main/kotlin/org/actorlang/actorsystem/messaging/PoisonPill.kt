package org.actorlang.actorsystem.messaging

/**
 * A special message that kills an actor when processed.
 * @param target The target actor reference (local or remote)
 */
class PoisonPill(target: ActorRef) : Message(target)

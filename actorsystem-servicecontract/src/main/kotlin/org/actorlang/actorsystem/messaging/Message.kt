package org.actorlang.actorsystem.messaging

import java.io.Serializable

/**
 * A message exchanged between actors.
 * @param target The target actor reference (local or remote)
 */
abstract class Message(val target: ActorRef) : Serializable

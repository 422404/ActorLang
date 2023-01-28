package org.actorlang.interpreter.objects.impl

import org.actorlang.actorsystem.messaging.ActorRef
import org.actorlang.actorsystem.messaging.Message

class ActorLangMessage(target: ActorRef, val args: Array<Any>) : Message(target)

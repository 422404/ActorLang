package org.actorlang.interpreter.comms

import org.actorlang.interpreter.Context
import org.actorlang.interpreter.objects.Actor

interface CommunicationsBinder {
    fun setContext(context: Context)
    fun bind(actor: Actor, actorMessageQueue: ActorMessageQueue)
    fun unbind(actor: Actor)
}

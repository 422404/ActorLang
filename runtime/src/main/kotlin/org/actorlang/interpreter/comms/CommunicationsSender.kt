package org.actorlang.interpreter.comms

import org.actorlang.interpreter.Context
import org.actorlang.interpreter.objects.Actor

interface CommunicationsSender {
    fun setContext(context: Context)
    fun send(message: Message, target: Actor)
}

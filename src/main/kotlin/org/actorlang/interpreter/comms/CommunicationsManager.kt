package org.actorlang.interpreter.comms

import org.actorlang.interpreter.Context
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.objects.Actor
import kotlin.random.Random

class CommunicationsManager : CommunicationsBinder, CommunicationsSender {
    private lateinit var context: Context

    private val boundActors = mutableMapOf<Actor, ActorMessageQueue>()

    override fun setContext(context: Context) {
        this.context = context
    }

    override fun bind(actor: Actor, actorMessageQueue: ActorMessageQueue) =
        synchronized(boundActors) {
            boundActors[actor] = actorMessageQueue
        }

    override fun unbind(actor: Actor): Unit = synchronized(boundActors) {
        boundActors.remove(actor)
    }

    override fun send(message: Message, target: Actor) {
        val actorMessageQueue = synchronized(boundActors) { boundActors[target] }
        if (actorMessageQueue != null) {
            pushMessage(message, actorMessageQueue)
        } else {
            throw ActorLangRuntimeException("The target actor is not bound")
        }
    }

    private fun pushMessage(message: Message, actorMessageQueue: ActorMessageQueue) {
        val messages = duplicateMessage(message)
        pushMessages(messages, actorMessageQueue)
    }

    private fun duplicateMessage(message: Message): List<Message> {
        val cfg = context.configuration
        val messages = mutableListOf(message)

        if (cfg.messageDuplicates) {
            for (i in 1..cfg.duplicatesMaxCount) {
                if (Random.nextFloat() < cfg.duplicationChances) {
                    messages += message
                }
            }
        }
        return messages
    }

    private fun pushMessages(
        messages: List<Message>,
        actorMessageQueue: ActorMessageQueue
    ) {
        val cfg = context.configuration

        for (message in messages) {
            val isOutOfOrder = cfg.outOfOrderMessages &&
                Random.nextFloat() < cfg.outOfOrderChances

            if (isOutOfOrder) {
                actorMessageQueue.pushRandomIndex(message)
            } else {
                actorMessageQueue.push(message)
            }
        }
    }
}

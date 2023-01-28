package org.actorlang.interpreter.objects

import mu.KotlinLogging
import org.actorlang.actorsystem.AbstractActorState
import org.actorlang.actorsystem.ActorSystem
import org.actorlang.actorsystem.messaging.Message
import org.actorlang.interpreter.objects.impl.ActorLangMessage

private val logger = KotlinLogging.logger {}

class ActorLangActorState(
    val actorStateClass: ActorLangActorStateClass,
    val stateVars: Array<Any>,
    actorSystem: ActorSystem,
) : AbstractActorState(actorSystem) {
    override fun handleMessage(message: Message) {
        if (message is ActorLangMessage) {
            handleActorLangMessage(message)
        }
        handleMessageDefault(message)
    }

    private fun handleActorLangMessage(message: ActorLangMessage) {
        val behavior = actorStateClass.behaviors.firstOrNull {
            it.canHandle(message)
        }

        if (behavior != null) {
            behavior.handle(message, this)
        } else {
            logger.warn("Actor state '${actorStateClass.stateName}' cannot handle message: $message")
        }
    }
}

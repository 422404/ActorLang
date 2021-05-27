package org.actorlang.interpreter.objects

import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.comms.ActorMessageQueueImpl
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.scheduler.ActorThreadImpl

class Actor(
    var actorType: ActorType,
    var state: Array<Any>,
    private val context: Context
): Runnable {
    fun become(actorTypeName: String, state: Array<Any>) = synchronized(actorType) {
        val actorType = context.actorTypes.getOrElse(actorTypeName) {
            throw ActorLangRuntimeException("Actor type '$actorTypeName' not declared")
        }
        if (actorType.stateVarNames.size != state.size) {
            throw ActorLangRuntimeException(
                "Cannot change actor type to '$actorTypeName', wrong state arity")
        }
        this.actorType = actorType
        this.state = state
    }

    fun receive(message: Message) = synchronized(actorType) {
        if (context.configuration.debug) {
            context.out.println("Received a message: $message")
        }
        val behavior = selectBehavior(message)
        behavior?.handle(this, message, context)
            ?: throw ActorLangRuntimeException("Cannot handle message $message")
    }

    override fun run() {
        val messageQueue = ActorMessageQueueImpl()
        context.communicationsBinder.bind(this, messageQueue)
        val thread = ActorThreadImpl(this, messageQueue)
        context.scheduler.schedule(thread)
    }

    private fun selectBehavior(message: Message): Behavior? {
        return actorType.behaviors
            .filter { it.behaviorNode.messagePatternItems.size == message.args.size }
            .firstOrNull { behavior ->
                behavior.behaviorNode.messagePatternItems
                    .mapIndexed { i, patternItem ->
                        patternItem to message.args[i]
                    }
                    .all {
                        val (patternItem, value) = it
                        when (patternItem) {
                            is BooleanLiteralNode ->
                                value is Boolean && patternItem.value == value
                            is IdentifierNode ->
                                true
                            is IntegerLiteralNode ->
                                value is Int && patternItem.value == value
                            is StringLiteralNode ->
                                value is String && patternItem.text == value
                            else -> throw IllegalStateException()
                        }
                    }
            }
    }
}

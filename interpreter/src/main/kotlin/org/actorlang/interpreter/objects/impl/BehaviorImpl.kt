package org.actorlang.interpreter.objects.impl

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.BehaviorEvaluator
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.objects.ActorLangActorState
import org.actorlang.interpreter.objects.Behavior

class BehaviorImpl(
    private val context: Context,
    private val actorSystem: ActorSystem,
    override val behaviorNode: BehaviorNode,
    private val rootScope: Scope
) : Behavior {
    override fun canHandle(message: ActorLangMessage): Boolean {
        return messageItemsMatchBehaviorSignature(message)
    }

    override fun handle(message: ActorLangMessage, actorState: ActorLangActorState) {
        val behaviorEvaluator = BehaviorEvaluator(context, actorSystem, actorState, message.args, rootScope)
        behaviorEvaluator.evaluateBehavior(behaviorNode)
    }

    private fun messageItemsMatchBehaviorSignature(message: ActorLangMessage): Boolean {
        return behaviorNode.messagePatternItems.size == message.args.size &&
            behaviorNode.messagePatternItems
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

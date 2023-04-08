package org.actorlang.interpreter.eval

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.ActorScope
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exception.WrongActorStateNameException
import org.actorlang.interpreter.exception.WrongBehaviorMessageArityException
import org.actorlang.interpreter.objects.ActorLangActorState

class BehaviorEvaluator(
    context: Context,
    actorSystem: ActorSystem,
    private val actorState: ActorLangActorState,
    private val messageItems: Array<Any>,
    private val rootScope: Scope
) : AbstractEvaluator(context, actorSystem) {
    fun evaluateBehavior(behaviorNode: BehaviorNode) {
        if (behaviorNode.messagePatternItems.size != messageItems.size) {
            throw WrongBehaviorMessageArityException(
                behaviorNode.messagePatternItems.size,
                messageItems.size,
                behaviorNode.startPosition
            )
        }
        activeScopes.add(rootScope)
        activeScopes.add(ActorScope(actorState, rootScope))
        activeScopes.add(BaseScope(currentScope))
        initBehaviorScope(behaviorNode)
        visit(behaviorNode)
    }

    private fun initBehaviorScope(behaviorNode: BehaviorNode) {
        behaviorNode.messagePatternItems
            .mapIndexed { i, patternItem ->
                patternItem to messageItems[i]
            }
            .forEach {
                val (patternItem, value) = it
                if (patternItem is IdentifierNode) {
                    currentScope.set(patternItem.name, value, behaviorNode.startPosition)
                }
            }
    }

    override fun visit(node: BecomeNode) {
        val stateValues = node.stateValues.map(this::visitExpression).toTypedArray()
        val actorStateClass = context.actorStateClasses[node.actorStateName.name]
            ?: throw WrongActorStateNameException(node.actorStateName.name, node.startPosition)

        actorState.become(actorStateClass.create(stateValues, node.startPosition))
    }

    override fun visit(node: BehaviorNode) {
        node.statements.forEach { visit(it) }
    }

    override fun visit(node: SelfLiteralNode) {
        result = actorState.actor.ref
    }

    override fun visit(node: FunctionDefNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot define a function inside of a behavior"
        )
    }
}

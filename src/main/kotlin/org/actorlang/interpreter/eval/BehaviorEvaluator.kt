package org.actorlang.interpreter.eval

import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.ActorScope
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exceptions.ChangeActorTypeException
import org.actorlang.interpreter.objects.Actor

class BehaviorEvaluator(
    private val actor: Actor,
    private val messageItems: Array<Any>,
    context: Context,
    private val rootScope: Scope
) : AbstractEvaluator(context) {
    fun evaluateBehavior(behaviorNode: BehaviorNode) {
        if (behaviorNode.messagePatternItems.size != messageItems.size) {
            throw ActorLangRuntimeException("Wrong behavior message arity")
        }
        activeScopes.add(rootScope)
        activeScopes.add(ActorScope(actor, rootScope))
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
                    currentScope[patternItem.name] = value
                }
            }
    }

    override fun visit(node: BecomeNode) {
        val stateValues = node.stateValues.map(this::visitExpression).toTypedArray()
        actor.become(node.behaviorName.name, stateValues)
        // Cancel the execution of the rest of the behavior code
        throw ChangeActorTypeException()
    }

    override fun visit(node: BehaviorNode) {
        node.statements.forEach { visit(it) }
    }

    override fun visit(node: SelfLiteralNode) {
        result = actor
    }
}

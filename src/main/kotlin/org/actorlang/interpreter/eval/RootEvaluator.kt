package org.actorlang.interpreter.eval

import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.RootNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.objects.ActorType
import org.actorlang.interpreter.objects.Behavior
import org.actorlang.interpreter.scopes.BaseScope

class RootEvaluator(
    context: Context
): AbstractEvaluator(context) {
    fun evaluateRoot(rootNode: RootNode) {
        activeScopes.push(BaseScope(null))
        visit(rootNode)
    }

    override fun visit(node: BecomeNode) {
        throwWithPosition(node.startPosition,
            "Cannot use 'become' outside an actor behavior")
    }

    override fun visit(node: BehaviorNode) {
        val actorType = context.actorTypes.getOrPut(node.name.name) {
            ActorType(node.name.name, node.stateVars.map { it.name }.toTypedArray())
        }

        if (node.stateVars.size != actorType.stateVarNames.size) {
            throwWithPosition(node.startPosition,
                "Wrong arity in actor type. Previously declared " +
                        "'${actorType.name}' has an arity of " +
                        "${actorType.stateVarNames.size} instead of " +
                        "${node.stateVars.size}")
        }

        actorType.behaviors += Behavior(actorType, node)
    }

    override fun visit(node: SelfLiteralNode) {
        throwWithPosition(node.startPosition,
            "Cannot use 'self' outside of a behavior")
    }
}

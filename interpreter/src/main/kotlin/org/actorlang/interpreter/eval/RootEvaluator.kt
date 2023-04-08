package org.actorlang.interpreter.eval

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.RootNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.objects.ActorLangActorStateClass
import org.actorlang.interpreter.objects.ActorLangFunction
import org.actorlang.interpreter.objects.impl.BehaviorImpl

class RootEvaluator(
    context: Context,
    actorSystem: ActorSystem
) : AbstractEvaluator(context, actorSystem) {
    fun evaluateRoot(rootNode: RootNode) {
        activeScopes.add(BaseScope(null))
        visit(rootNode)
    }

    override fun visit(node: BecomeNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot use a 'become' statement outside of an actor behavior"
        )
    }

    override fun visit(node: BehaviorNode) {
        val actorStateClass = context.actorStateClasses.getOrPut(node.name.name) {
            ActorLangActorStateClass(
                node.name.name,
                node.stateVars.map { it.name }.toTypedArray(),
                actorSystem
            )
        }

        if (node.stateVars.size != actorStateClass.stateVarsNames.size) {
            throwWithPosition(
                node.startPosition,
                "Wrong arity in actor type. Previously declared " +
                    "'${actorStateClass.stateName}' has an arity of " +
                    "${actorStateClass.stateVarsNames.size} instead of " +
                    "${node.stateVars.size}"
            )
        }

        actorStateClass.behaviors += BehaviorImpl(context, actorSystem, node, currentScope)
    }

    override fun visit(node: SelfLiteralNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot use the 'self' variable outside of a behavior body"
        )
    }

    override fun visit(node: FunctionDefNode) {
        if (context.functions[node.functionName.name] != null) {
            throwWithPosition(
                node.startPosition,
                "A function named ${node.functionName.name} is already defined"
            )
        }

        context.functions[node.functionName.name] = ActorLangFunction(
            actorSystem,
            node.functionName.name,
            node,
            currentScope
        )
    }
}

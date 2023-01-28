package org.actorlang.interpreter.eval

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exception.FunctionReturnException
import org.actorlang.interpreter.exception.WrongFunctionArityException
import org.actorlang.interpreter.objects.ActorLangFunction

class FunctionEvaluator(
    context: Context,
    actorSystem: ActorSystem,
    private val function: ActorLangFunction,
    private val args: Array<Any>,
    private val rootScope: Scope
) : AbstractEvaluator(context, actorSystem) {
    fun evaluateFunction(): Any {
        val actualArgsCount = args.size
        val expectedArgsCount = function.functionDefNode.argsNames.size

        if (actualArgsCount != expectedArgsCount) {
            throw WrongFunctionArityException(
                function.name,
                expectedArgsCount,
                actualArgsCount,
                function.functionDefNode.startPosition
            )
        }
        activeScopes.add(rootScope)
        activeScopes.add(BaseScope(rootScope))
        initFunctionScope()

        return try {
            visit(function.functionDefNode)
        } catch (e: FunctionReturnException) {
            // What a super nice goto ...
            e.value
        }
    }

    private fun initFunctionScope() {
        function.functionDefNode.argsNames
            .mapIndexed { i, argName ->
                argName to args[i]
            }
            .forEach {
                val (argName, value) = it
                currentScope.set(argName.name, value, function.functionDefNode.startPosition)
            }
    }

    override fun visit(node: BecomeNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot use 'become' inside of a function"
        )
    }

    override fun visit(node: BehaviorNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot define a behavior inside of a function"
        )
    }

    override fun visit(node: SelfLiteralNode) {
        throwWithPosition(
            node.startPosition,
            "Cannot use 'self' inside of a function"
        )
    }

    override fun visit(node: FunctionDefNode) {
        node.returnExpression?.let {
            returnFromFunction(it)
        }
        node.statements?.forEach { visit(it) }
    }
}

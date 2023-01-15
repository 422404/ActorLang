package org.actorlang.interpreter.eval

import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.FunctionDefNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.scopes.BaseScope
import org.actorlang.interpreter.eval.scopes.Scope
import org.actorlang.interpreter.exceptions.FunctionReturnException
import org.actorlang.interpreter.exceptions.WrongFunctionArityException
import org.actorlang.interpreter.objects.ActorLangFunction

class FunctionEvaluator(
    context: Context,
    private val function: ActorLangFunction,
    private val args: Array<Any>,
    private val rootScope: Scope
) : AbstractEvaluator(context) {
    fun evaluateFunction(): Any {
        val given = args.size
        val required = function.functionDefNode.argsNames.size

        if (given != required) {
            throw WrongFunctionArityException(
                function.name,
                required,
                given
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
                currentScope[argName.name] = value
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

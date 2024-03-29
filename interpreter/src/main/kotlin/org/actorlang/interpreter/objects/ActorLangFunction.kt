package org.actorlang.interpreter.objects

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.FunctionDefNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.eval.FunctionEvaluator
import org.actorlang.interpreter.eval.scopes.Scope

class ActorLangFunction(
    private val actorSystem: ActorSystem,
    val name: String,
    val functionDefNode: FunctionDefNode,
    private val rootScope: Scope
) {
    fun call(args: Array<Any>, context: Context): Any {
        val functionEvaluator = FunctionEvaluator(context, actorSystem, this, args, rootScope)
        return functionEvaluator.evaluateFunction()
    }
}

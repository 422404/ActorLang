package org.actorlang.interpreter.eval.scopes

import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.objects.Actor

class ActorScope(
    val actor: Actor,
    parent: Scope?
) : Scope(parent) {
    override fun set(name: String, value: Any) {
        throw ActorLangRuntimeException("Cannot assign values to actor state.")
    }

    override fun get(name: String): Any {
        val varIndex = actor.actorType.stateVarNames.indexOf(name)
        if (varIndex < 0) {
            when (parent) {
                null -> throw ActorLangRuntimeException("Variable '$name' not in scope")
                else -> return parent[name]
            }
        }
        return actor.state[varIndex]
    }
}

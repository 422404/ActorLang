package org.actorlang.interpreter.eval.scopes

import org.actorlang.interpreter.exception.ActorLangRuntimeException
import org.actorlang.interpreter.objects.ActorLangActorState
import org.actorlang.parser.Position

class ActorScope(
    private val actorState: ActorLangActorState,
    parent: Scope?
) : Scope(parent) {
    override fun set(name: String, value: Any, sourcePosition: Position) {
        throw ActorLangRuntimeException("Cannot assign values to actor state variables", sourcePosition)
    }

    override fun get(name: String, sourcePosition: Position): Any {
        val varIndex = actorState.actorStateClass.stateVarsNames.indexOf(name)
        if (varIndex < 0) {
            when (parent) {
                null -> throw ActorLangRuntimeException("Variable '$name' not in scope", sourcePosition)
                else -> return parent.get(name, sourcePosition)
            }
        }
        return actorState.stateVars[varIndex]
    }
}

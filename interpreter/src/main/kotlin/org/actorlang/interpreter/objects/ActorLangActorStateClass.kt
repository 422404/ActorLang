package org.actorlang.interpreter.objects

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.interpreter.exception.WrongActorStateArityException
import org.actorlang.parser.Position

/**
 * Represents an actor state to be instanced.
 */
class ActorLangActorStateClass(
    val stateName: String,
    val stateVarsNames: Array<String>,
    private val actorSystem: ActorSystem,
) {
    val behaviors: MutableList<Behavior> = mutableListOf()

    fun create(stateVars: Array<Any>, sourcePosition: Position): ActorLangActorState {
        if (stateVars.size != stateVarsNames.size) {
            throw WrongActorStateArityException(
                stateName,
                stateVarsNames.size,
                stateVars.size,
                sourcePosition
            )
        }

        return ActorLangActorState(this, stateVars, actorSystem)
    }
}

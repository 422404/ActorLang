package org.actorlang.interpreter.exception

import org.actorlang.parser.Position

class WrongActorStateArityException(
    actorStateName: String,
    expectedStateVarsCount: Int,
    actualStateVarsCount: Int,
    sourcePosition: Position
) : ActorLangRuntimeException(
    "Actor state '$actorStateName' has an arity of $expectedStateVarsCount but $actualStateVarsCount arguments were supplied",
    sourcePosition
)

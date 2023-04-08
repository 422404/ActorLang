package org.actorlang.interpreter.exception

import org.actorlang.parser.Position

class WrongActorStateNameException(
    actorStateName: String,
    sourcePosition: Position
) : ActorLangRuntimeException(
    "No actor state is named '$actorStateName'",
    sourcePosition
)

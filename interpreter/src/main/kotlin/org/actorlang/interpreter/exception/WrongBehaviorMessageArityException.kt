package org.actorlang.interpreter.exception

import org.actorlang.parser.Position

class WrongBehaviorMessageArityException(
    expectedMessageItemsCount: Int,
    actualMessageItemsCount: Int,
    sourcePosition: Position
) : ActorLangRuntimeException(
    "The behavior must be executed with $expectedMessageItemsCount message items but $actualMessageItemsCount were given",
    sourcePosition
)

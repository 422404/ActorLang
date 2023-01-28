package org.actorlang.interpreter.exception

import org.actorlang.parser.Position

class UnknownFunctionException(
    functionName: String,
    sourcePosition: Position
) : ActorLangRuntimeException(
    "Unknown function named '$functionName'",
    sourcePosition
)

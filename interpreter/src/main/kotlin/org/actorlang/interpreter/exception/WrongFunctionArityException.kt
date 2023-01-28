package org.actorlang.interpreter.exception

import org.actorlang.parser.Position

class WrongFunctionArityException(
    functionName: String,
    expectedArgsCount: Int,
    actualArgsCount: Int,
    sourcePosition: Position
) : ActorLangRuntimeException(
    "Function '$functionName' has an arity of $expectedArgsCount but $actualArgsCount arguments were supplied",
    sourcePosition
)

package org.actorlang.interpreter.exceptions

import org.actorlang.exceptions.ActorLangRuntimeException

class WrongFunctionArityException(
    functionName: String,
    functionArity: Int,
    givenArgsCount: Int
) : ActorLangRuntimeException(
    "Function '$functionName' called with the wrong number of arguments. " +
        "Should be $functionArity but $givenArgsCount given."
)

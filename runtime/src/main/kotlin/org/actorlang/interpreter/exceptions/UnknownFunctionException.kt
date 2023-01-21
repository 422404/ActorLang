package org.actorlang.interpreter.exceptions

import org.actorlang.exceptions.ActorLangRuntimeException

class UnknownFunctionException(
    val name: String
) : ActorLangRuntimeException("Function '$name()' is unknown.")

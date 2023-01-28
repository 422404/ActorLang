package org.actorlang.interpreter.exception

import org.actorlang.parser.Position
import java.lang.Exception

open class ActorLangRuntimeException(
    msg: String,
    val sourcePosition: Position
) : Exception(msg)

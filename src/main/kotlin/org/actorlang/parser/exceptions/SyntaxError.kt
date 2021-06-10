package org.actorlang.parser.exceptions

import org.actorlang.exceptions.ActorLangRuntimeException
import org.actorlang.parser.Position

class SyntaxError(
    msg: String,
    position: Position
) : ActorLangRuntimeException("Syntax error at ${position.sourceName}:${position.line}:${position.column}: $msg")

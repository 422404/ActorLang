package org.actorlang.parser.exceptions

import org.actorlang.parser.Position

class SyntaxError(
    msg: String,
    position: Position
) : ActorLangParsingException("Syntax error at ${position.sourceName}:${position.line}:${position.column}: $msg")

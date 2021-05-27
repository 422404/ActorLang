package org.actorlang.parser.exceptions

import org.actorlang.parser.Position

class SyntaxError(
    msg: String,
    position: Position
): Exception("Syntax error at ${position.sourceName}:${position.line}:${position.column}: $msg")

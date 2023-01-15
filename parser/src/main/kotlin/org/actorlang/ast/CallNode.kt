package org.actorlang.ast

import org.actorlang.parser.Position

class CallNode(
    startPosition: Position,
    endPosition: Position,
    val functionCall: org.actorlang.ast.FunctionCallNode
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

package org.actorlang.ast

import org.actorlang.parser.Position

class CallNode(
    startPosition: Position,
    endPosition: Position,
    val functionCall: FunctionCallNode
) : StatementNode(startPosition, endPosition)

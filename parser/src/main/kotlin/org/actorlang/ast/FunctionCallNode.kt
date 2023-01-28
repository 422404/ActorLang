package org.actorlang.ast

import org.actorlang.parser.Position

class FunctionCallNode(
    startPosition: Position,
    endPosition: Position,
    val functionName: IdentifierNode,
    val args: Array<ExpressionNode>
) : ExpressionNode(startPosition, endPosition)

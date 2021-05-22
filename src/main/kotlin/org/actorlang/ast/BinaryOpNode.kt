package org.actorlang.ast

import org.actorlang.parser.Position

class BinaryOpNode(
    startPosition: Position,
    endPosition: Position,
    val left: ExpressionNode,
    val right: ExpressionNode?,
    val type: BinaryOpType
): ExpressionNode(startPosition, endPosition)

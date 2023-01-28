package org.actorlang.ast

import org.actorlang.parser.Position

class UnaryOpNode(
    startPosition: Position,
    endPosition: Position,
    val operand: ExpressionNode,
    val type: UnaryOpType
) : ExpressionNode(startPosition, endPosition)

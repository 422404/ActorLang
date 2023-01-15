package org.actorlang.ast

import org.actorlang.parser.Position

class BinaryOpNode(
    startPosition: Position,
    endPosition: Position,
    val left: org.actorlang.ast.ExpressionNode,
    val right: org.actorlang.ast.ExpressionNode?,
    val type: org.actorlang.ast.BinaryOpType
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition)

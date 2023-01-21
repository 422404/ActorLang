package org.actorlang.ast

import org.actorlang.parser.Position

class UnaryOpNode(
    startPosition: Position,
    endPosition: Position,
    val operand: org.actorlang.ast.ExpressionNode,
    val type: org.actorlang.ast.UnaryOpType
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition)

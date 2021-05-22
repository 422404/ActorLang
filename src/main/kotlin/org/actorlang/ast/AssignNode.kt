package org.actorlang.ast

import org.actorlang.parser.Position

class AssignNode(
    startPosition: Position,
    endPosition: Position,
    val variable: IdentifierNode,
    val value: ExpressionNode
): StatementNode(startPosition, endPosition)

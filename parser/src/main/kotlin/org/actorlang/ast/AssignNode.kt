package org.actorlang.ast

import org.actorlang.parser.Position

class AssignNode(
    startPosition: Position,
    endPosition: Position,
    val variable: org.actorlang.ast.IdentifierNode,
    val value: org.actorlang.ast.ExpressionNode
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

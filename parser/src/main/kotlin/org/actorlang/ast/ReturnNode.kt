package org.actorlang.ast

import org.actorlang.parser.Position

class ReturnNode(
    startPosition: Position,
    endPosition: Position,
    val expression: org.actorlang.ast.ExpressionNode
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

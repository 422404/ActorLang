package org.actorlang.ast

import org.actorlang.parser.Position

class ReturnNode(
    startPosition: Position,
    endPosition: Position,
    val expression: ExpressionNode
) : StatementNode(startPosition, endPosition)

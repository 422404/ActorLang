package org.actorlang.ast

import org.actorlang.parser.Position

class PutNode(
    startPosition: Position,
    endPosition: Position,
    val value: ExpressionNode
) : StatementNode(startPosition, endPosition)

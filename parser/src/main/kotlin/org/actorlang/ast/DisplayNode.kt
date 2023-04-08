package org.actorlang.ast

import org.actorlang.parser.Position

class DisplayNode(
    startPosition: Position,
    endPosition: Position,
    val value: ExpressionNode
) : StatementNode(startPosition, endPosition)

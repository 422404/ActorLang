package org.actorlang.ast

import org.actorlang.parser.Position

class SendNode(
    startPosition: Position,
    endPosition: Position,
    val messageItems: Array<ExpressionNode>,
    val target: IdentifierNode
): StatementNode(startPosition, endPosition)

package org.actorlang.ast

import org.actorlang.parser.Position

class SendNode(
    startPosition: Position,
    endPosition: Position,
    val messageItems: Array<org.actorlang.ast.ExpressionNode>,
    val target: org.actorlang.ast.IdentifierNode
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

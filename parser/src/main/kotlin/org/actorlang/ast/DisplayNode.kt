package org.actorlang.ast

import org.actorlang.parser.Position

class DisplayNode(
    startPosition: Position,
    endPosition: Position,
    val value: org.actorlang.ast.ExpressionNode
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

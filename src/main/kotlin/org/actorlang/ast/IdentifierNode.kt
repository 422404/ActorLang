package org.actorlang.ast

import org.actorlang.parser.Position

class IdentifierNode(
    startPosition: Position,
    endPosition: Position,
    val name: String
) : ExpressionNode(startPosition, endPosition), MessagePatternItem

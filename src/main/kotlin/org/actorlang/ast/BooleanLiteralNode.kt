package org.actorlang.ast

import org.actorlang.parser.Position

class BooleanLiteralNode(
    startPosition: Position,
    endPosition: Position,
    val value: Boolean
) : ExpressionNode(startPosition, endPosition), MessagePatternItem

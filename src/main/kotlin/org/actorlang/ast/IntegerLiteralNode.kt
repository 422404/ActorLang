package org.actorlang.ast

import org.actorlang.parser.Position

class IntegerLiteralNode(
    startPosition: Position,
    endPosition: Position,
    val value: Int
): ExpressionNode(startPosition, endPosition), MessagePatternItem

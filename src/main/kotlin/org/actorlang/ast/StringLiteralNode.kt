package org.actorlang.ast

import org.actorlang.parser.Position

class StringLiteralNode(
    startPosition: Position,
    endPosition: Position,
    val text: String
): ExpressionNode(startPosition, endPosition), MessagePatternItem

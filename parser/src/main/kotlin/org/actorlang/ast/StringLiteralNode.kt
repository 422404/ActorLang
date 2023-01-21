package org.actorlang.ast

import org.actorlang.parser.Position

class StringLiteralNode(
    startPosition: Position,
    endPosition: Position,
    val text: String
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition), org.actorlang.ast.MessagePatternItem

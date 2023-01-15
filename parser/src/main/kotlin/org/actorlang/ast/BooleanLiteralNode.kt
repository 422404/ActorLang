package org.actorlang.ast

import org.actorlang.parser.Position

class BooleanLiteralNode(
    startPosition: Position,
    endPosition: Position,
    val value: Boolean
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition), org.actorlang.ast.MessagePatternItem

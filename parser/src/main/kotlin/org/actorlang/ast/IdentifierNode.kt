package org.actorlang.ast

import org.actorlang.parser.Position

class IdentifierNode(
    startPosition: Position,
    endPosition: Position,
    val name: String
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition), org.actorlang.ast.MessagePatternItem

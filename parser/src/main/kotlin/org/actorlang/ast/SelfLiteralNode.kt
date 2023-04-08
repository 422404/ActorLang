package org.actorlang.ast

import org.actorlang.parser.Position

class SelfLiteralNode(
    startPosition: Position,
    endPosition: Position
) : ExpressionNode(startPosition, endPosition)

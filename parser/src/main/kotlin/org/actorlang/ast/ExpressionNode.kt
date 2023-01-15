package org.actorlang.ast

import org.actorlang.parser.Position

abstract class ExpressionNode(
    startPosition: Position,
    endPosition: Position
) : org.actorlang.ast.Node(startPosition, endPosition)

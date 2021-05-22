package org.actorlang.ast

import org.actorlang.parser.Position

abstract class StatementNode(
    startPosition: Position,
    endPosition: Position
): Node(startPosition, endPosition)

package org.actorlang.ast

import org.actorlang.parser.Position

class RootNode(
    startPosition: Position,
    endPosition: Position
): Node(startPosition, endPosition) {
}

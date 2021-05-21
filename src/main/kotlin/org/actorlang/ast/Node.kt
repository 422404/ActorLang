package org.actorlang.ast

import org.actorlang.parser.Position

abstract class Node(
    val startPosition: Position,
    val endPosition: Position
)

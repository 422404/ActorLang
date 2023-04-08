package org.actorlang.ast

import org.actorlang.parser.Position

class CreateNode(
    startPosition: Position,
    endPosition: Position,
    val behaviorName: IdentifierNode,
    val stateValues: Array<ExpressionNode>
) : ExpressionNode(startPosition, endPosition)

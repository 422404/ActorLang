package org.actorlang.ast

import org.actorlang.parser.Position

class CreateNode(
    startPosition: Position,
    endPosition: Position,
    val behaviorName: org.actorlang.ast.IdentifierNode,
    val stateValues: Array<org.actorlang.ast.ExpressionNode>
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition)

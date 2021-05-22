package org.actorlang.ast

import org.actorlang.parser.Position

class BecomeNode(
    startPosition: Position,
    endPosition: Position,
    val behaviorName: IdentifierNode,
    val stateValues: Array<ExpressionNode>
): StatementNode(startPosition, endPosition)

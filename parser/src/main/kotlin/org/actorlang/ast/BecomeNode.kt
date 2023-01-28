package org.actorlang.ast

import org.actorlang.parser.Position

class BecomeNode(
    startPosition: Position,
    endPosition: Position,
    val actorStateName: IdentifierNode,
    val stateValues: Array<ExpressionNode>
) : StatementNode(startPosition, endPosition)

package org.actorlang.ast

import org.actorlang.parser.Position

class BecomeNode(
    startPosition: Position,
    endPosition: Position,
    val behaviorName: org.actorlang.ast.IdentifierNode,
    val stateValues: Array<org.actorlang.ast.ExpressionNode>
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

package org.actorlang.ast

import org.actorlang.parser.Position

class IfNode(
    startPosition: Position,
    endPosition: Position,
    val condition: ExpressionNode,
    val thenStatements: Array<StatementNode>,
    val elseStatements: Array<StatementNode>
): StatementNode(startPosition, endPosition)

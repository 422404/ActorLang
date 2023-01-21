package org.actorlang.ast

import org.actorlang.parser.Position

class IfNode(
    startPosition: Position,
    endPosition: Position,
    val condition: org.actorlang.ast.ExpressionNode,
    val thenStatements: Array<org.actorlang.ast.StatementNode>,
    val elseStatements: Array<org.actorlang.ast.StatementNode>
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

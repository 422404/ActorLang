package org.actorlang.ast

import org.actorlang.parser.Position

class ForNode(
    startPosition: Position,
    endPosition: Position,
    val variable: org.actorlang.ast.IdentifierNode,
    val range: Pair<org.actorlang.ast.ExpressionNode, org.actorlang.ast.ExpressionNode>,
    val statements: Array<org.actorlang.ast.StatementNode>
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

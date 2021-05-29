package org.actorlang.ast

import org.actorlang.parser.Position

class ForNode(
    startPosition: Position,
    endPosition: Position,
    val variable: IdentifierNode,
    val range: Pair<ExpressionNode, ExpressionNode>,
    val statements: Array<StatementNode>
) : StatementNode(startPosition, endPosition)

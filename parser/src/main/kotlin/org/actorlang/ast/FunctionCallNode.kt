package org.actorlang.ast

import org.actorlang.parser.Position

class FunctionCallNode(
    startPosition: Position,
    endPosition: Position,
    val functionName: org.actorlang.ast.IdentifierNode,
    val args: Array<org.actorlang.ast.ExpressionNode>
) : org.actorlang.ast.ExpressionNode(startPosition, endPosition)

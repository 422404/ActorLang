package org.actorlang.ast

import org.actorlang.parser.Position

class FunctionDefNode(
    startPosition: Position,
    endPosition: Position,
    val functionName: org.actorlang.ast.IdentifierNode,
    val argsNames: Array<org.actorlang.ast.IdentifierNode>,
    /**
     * Set if the function is defined using an expression.
     * Example:
     * fun F(x) = x * x;
     */
    val returnExpression: org.actorlang.ast.ExpressionNode?,
    /**
     * Set if the function is defined using a statement or a block.
     * Examples:
     * fun G(x) = display x;
     * fun H(x) = {
     *     display x * 2
     * };
     */
    val statements: Array<org.actorlang.ast.StatementNode>?
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

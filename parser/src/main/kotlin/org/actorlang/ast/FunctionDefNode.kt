package org.actorlang.ast

import org.actorlang.parser.Position

class FunctionDefNode(
    startPosition: Position,
    endPosition: Position,
    val functionName: IdentifierNode,
    val argsNames: Array<IdentifierNode>,
    /**
     * Set if the function is defined using an expression.
     * Example:
     * fun F(x) = x * x;
     */
    val returnExpression: ExpressionNode?,
    /**
     * Set if the function is defined using a statement or a block.
     * Examples:
     * fun G(x) = display x;
     * fun H(x) = {
     *     display x * 2
     * };
     */
    val statements: Array<StatementNode>?
) : StatementNode(startPosition, endPosition)

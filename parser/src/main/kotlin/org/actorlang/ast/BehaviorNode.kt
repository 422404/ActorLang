package org.actorlang.ast

import org.actorlang.parser.Position

class BehaviorNode(
    startPosition: Position,
    endPosition: Position,
    val name: org.actorlang.ast.IdentifierNode,
    val stateVars: Array<org.actorlang.ast.IdentifierNode>,
    val messagePatternItems: Array<org.actorlang.ast.MessagePatternItem>,
    val statements: Array<org.actorlang.ast.StatementNode>
) : org.actorlang.ast.StatementNode(startPosition, endPosition)

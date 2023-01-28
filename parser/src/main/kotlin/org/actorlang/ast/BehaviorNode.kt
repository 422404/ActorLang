package org.actorlang.ast

import org.actorlang.parser.Position

class BehaviorNode(
    startPosition: Position,
    endPosition: Position,
    val name: IdentifierNode,
    val stateVars: Array<IdentifierNode>,
    val messagePatternItems: Array<MessagePatternItem>,
    val statements: Array<StatementNode>
) : StatementNode(startPosition, endPosition)

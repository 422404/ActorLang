package org.actorlang.ast

import org.actorlang.parser.Position

class RootNode(
    startPosition: Position,
    endPosition: Position,
    val toplevelStatements: Array<org.actorlang.ast.StatementNode>
) : org.actorlang.ast.Node(startPosition, endPosition)

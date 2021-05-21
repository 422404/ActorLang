package org.actorlang.parser

import org.actorlang.ast.Node

interface Parser {
    fun parse(text: String): Node
}

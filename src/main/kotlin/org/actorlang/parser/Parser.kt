package org.actorlang.parser

import org.actorlang.ast.RootNode

interface Parser {
    fun parse(text: String): RootNode
}

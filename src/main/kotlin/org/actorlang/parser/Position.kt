package org.actorlang.parser

data class Position(
    val line: Int,
    val column: Int,
    val filePath: String
)

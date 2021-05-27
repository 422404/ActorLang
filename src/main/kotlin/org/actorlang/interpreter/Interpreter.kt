package org.actorlang.interpreter

interface Interpreter {
    fun run(source: String, sourceName: String)
}

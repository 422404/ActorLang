package org.actorlang.interpreter

import java.io.File

interface Interpreter {
    fun run(source: String, filePath: String)
    fun run(file: File)
}

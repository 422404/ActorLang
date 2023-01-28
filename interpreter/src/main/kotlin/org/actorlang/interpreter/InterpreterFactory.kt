package org.actorlang.interpreter

import java.io.PrintStream

interface InterpreterFactory {
    /**
     * Creates a new default interpreter.
     * This interpreter uses the default [PrintStream] (System.out).
     */
    fun createDefaultInterpreter(): Interpreter

    /**
     * Creates a new default interpreter and a given [PrintStream].
     * @param stdout The [PrintStream] used for 'display' and 'put' statements
     */
    fun createDefaultInterpreter(stdout: PrintStream): Interpreter
}

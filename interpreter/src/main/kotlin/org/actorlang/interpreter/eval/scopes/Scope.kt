package org.actorlang.interpreter.eval.scopes

import org.actorlang.parser.Position

abstract class Scope(
    val parent: Scope?
) {
    /**
     * Sets a variable value in the scope.
     * @param name The variable name
     * @param value The value
     * @param sourcePosition The source code position of the variable access.
     *                       Used for error messages.
     */
    abstract fun set(name: String, value: Any, sourcePosition: Position)

    /**
     * Gets the value of a variable in the scope or its parents.
     * @param name The variable name
     * @param sourcePosition The source code position of the variable access.
     *                       Used for error messages.
     */
    abstract fun get(name: String, sourcePosition: Position): Any
}

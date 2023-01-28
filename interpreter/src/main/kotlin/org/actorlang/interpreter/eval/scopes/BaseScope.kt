package org.actorlang.interpreter.eval.scopes

import org.actorlang.interpreter.exception.ActorLangRuntimeException
import org.actorlang.parser.Position

class BaseScope(parent: Scope?) : Scope(parent) {
    private val vars = mutableMapOf<String, Any>()

    override fun set(name: String, value: Any, sourcePosition: Position) {
        vars[name] = value
    }

    override fun get(name: String, sourcePosition: Position): Any {
        return vars.getOrElse(name) {
            when (parent) {
                null -> throw ActorLangRuntimeException("Variable '$name' not in scope", sourcePosition)
                else -> parent.get(name, sourcePosition)
            }
        }
    }
}

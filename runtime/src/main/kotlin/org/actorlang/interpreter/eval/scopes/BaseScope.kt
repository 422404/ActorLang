package org.actorlang.interpreter.eval.scopes

import org.actorlang.exceptions.ActorLangRuntimeException

class BaseScope(parent: Scope?) : Scope(parent) {
    private val vars = mutableMapOf<String, Any>()

    override fun set(name: String, value: Any) {
        vars[name] = value
    }

    override fun get(name: String): Any {
        return vars.getOrElse(name) {
            when (parent) {
                null -> throw ActorLangRuntimeException("Variable '$name' not in scope")
                else -> parent[name]
            }
        }
    }
}

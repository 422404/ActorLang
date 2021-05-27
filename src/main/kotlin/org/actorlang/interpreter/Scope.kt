package org.actorlang.interpreter

abstract class Scope(
    val parent: Scope?
) {
    abstract operator fun set(name: String, value: Any)
    abstract operator fun get(name: String): Any
}

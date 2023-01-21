package org.actorlang.interpreter.objects

class ActorType(
    val name: String,
    val stateVarNames: Array<String>
) {
    val behaviors = mutableListOf<Behavior>()
}

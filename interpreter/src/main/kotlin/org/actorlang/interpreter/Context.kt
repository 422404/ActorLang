package org.actorlang.interpreter

import org.actorlang.interpreter.objects.ActorLangActorStateClass
import org.actorlang.interpreter.objects.ActorLangFunction
import java.io.PrintStream

data class Context(
    val stdout: PrintStream,
    val actorStateClasses: MutableMap<String, ActorLangActorStateClass>,
    val functions: MutableMap<String, ActorLangFunction>
) {
    companion object {
        /**
         * Creates a new empty context.
         * @param stdout The [PrintStream] to use
         */
        fun of(stdout: PrintStream) = Context(stdout, mutableMapOf(), mutableMapOf())
    }
}

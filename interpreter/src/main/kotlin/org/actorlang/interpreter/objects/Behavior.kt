package org.actorlang.interpreter.objects

import org.actorlang.ast.BehaviorNode
import org.actorlang.interpreter.objects.impl.ActorLangMessage

interface Behavior {
    val behaviorNode: BehaviorNode
    fun canHandle(message: ActorLangMessage): Boolean
    fun handle(message: ActorLangMessage, actorState: ActorLangActorState)
}

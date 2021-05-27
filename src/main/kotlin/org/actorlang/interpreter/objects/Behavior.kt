package org.actorlang.interpreter.objects

import org.actorlang.ast.BehaviorNode
import org.actorlang.interpreter.Context
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.eval.BehaviorEvaluator
import org.actorlang.interpreter.exceptions.ChangeActorTypeException

class Behavior(
    val actorType: ActorType,
    val behaviorNode: BehaviorNode
) {
    fun handle(actor: Actor, message: Message, context: Context) {
        val behaviorEvaluator = BehaviorEvaluator(actor, message.args, context)
        try {
            behaviorEvaluator.evaluateBehavior(behaviorNode)
        } catch (unused: ChangeActorTypeException) {
            // What a nice goto...
        }
    }
}

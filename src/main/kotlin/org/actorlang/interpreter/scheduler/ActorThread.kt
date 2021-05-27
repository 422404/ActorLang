package org.actorlang.interpreter.scheduler

import org.actorlang.interpreter.comms.ActorMessageQueue
import org.actorlang.interpreter.objects.Actor

abstract class ActorThread(
    val actor: Actor,
    val actorMessageQueue: ActorMessageQueue
): Thread() {
    abstract fun stopWhenPermitted()
}

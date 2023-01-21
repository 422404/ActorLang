package org.actorlang.interpreter.scheduler

import org.actorlang.interpreter.comms.ActorMessageQueue
import org.actorlang.interpreter.objects.Actor

abstract class ActorThread(
    protected val actor: Actor,
    protected val actorMessageQueue: ActorMessageQueue
) : Thread() {
    abstract val state: ActorThreadState
    abstract fun stopWhenPermitted()
}

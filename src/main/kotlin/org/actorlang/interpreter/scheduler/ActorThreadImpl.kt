package org.actorlang.interpreter.scheduler

import org.actorlang.interpreter.comms.ActorMessageQueue
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.objects.Actor

private const val PULL_TIMEOUT_MILLIS = 50L

class ActorThreadImpl(
    actor: Actor,
    actorMessageQueue: ActorMessageQueue
): ActorThread(actor, actorMessageQueue) {
    private var mustRun = true

    override fun run() {
        var message: Message?

        while (mustRun) {
            message = actorMessageQueue.pull(PULL_TIMEOUT_MILLIS)
            if (message != null) {
                actor.receive(message)
            }
        }
    }

    override fun stopWhenPermitted() {
        mustRun = false
    }
}

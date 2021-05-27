package org.actorlang.interpreter.scheduler

import org.actorlang.interpreter.Context
import org.actorlang.interpreter.comms.ActorMessageQueue
import org.actorlang.interpreter.comms.Message
import org.actorlang.interpreter.objects.Actor
import kotlin.random.Random

private const val PULL_TIMEOUT_MILLIS = 50L

class ActorThreadImpl(
    actor: Actor,
    actorMessageQueue: ActorMessageQueue,
    private val context: Context
): ActorThread(actor, actorMessageQueue) {
    private var mustRun = true

    override fun run() {
        var message: Message?

        while (mustRun) {
            message = actorMessageQueue.pull(PULL_TIMEOUT_MILLIS)
            if (message != null) {
                simulateLatency()
                actor.receive(message)
            }
        }
    }

    private fun simulateLatency() {
        sleep(Random.nextLong(
            context.configuration.messageLatencyMaxMillis + 1))
    }

    override fun stopWhenPermitted() {
        mustRun = false
    }
}

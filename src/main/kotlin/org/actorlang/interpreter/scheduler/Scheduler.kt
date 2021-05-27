package org.actorlang.interpreter.scheduler

interface Scheduler {
    fun schedule(actorThread: ActorThread)
    fun join()
}

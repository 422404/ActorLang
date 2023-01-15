package org.actorlang.interpreter.scheduler

interface SchedulerSynchronization {
    fun pullTimeout(actorThread: ActorThread)
    fun execeptionThrown(actorThread: ActorThread, e: Exception)
}

package org.actorlang.interpreter.scheduler

import java.lang.Thread.sleep

class SchedulerImpl: Scheduler {
    private val actorThreads = mutableListOf<ActorThread>()

    override fun schedule(actorThread: ActorThread) = synchronized(actorThreads) {
        actorThreads += actorThread
        actorThread.start()
    }

    override fun join() {
        // TODO Better synchronization
        sleep(5000)
        actorThreads.forEach {
            it.stopWhenPermitted()
            it.join()
        }
    }
}

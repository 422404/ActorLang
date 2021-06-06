package org.actorlang.interpreter.scheduler

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class SchedulerImpl : Scheduler, SchedulerSynchronization {
    private val activeThreads = mutableListOf<ActorThread>()
    private val joignableThreads = mutableListOf<ActorThread>()
    private var exception: Exception? = null
    private val lock = ReentrantLock()
    private val idleThreadsCondition = lock.newCondition()

    override fun schedule(actorThread: ActorThread) = synchronized(activeThreads) {
        activeThreads += actorThread
        actorThread.start()
    }

    override fun join() {
        lock.withLock {
            if (synchronized(activeThreads) { activeThreads.size } > 0) {
                idleThreadsCondition.await()
            }
        }
        joinAllThreads()
        if (exception != null) {
            throw exception!!
        }
    }

    override fun pullTimeout(actorThread: ActorThread) = synchronized(activeThreads) {
        if (activeThreads.all { it.state == ActorThreadState.TIMEOUT }) {
            lock.withLock {
                moveAllToJoignableThreads()
                idleThreadsCondition.signal()
            }
        }
    }

    override fun execeptionThrown(actorThread: ActorThread, e: Exception) {
        // We will throw the first exception encountered
        if (exception == null) {
            exception = e
        }
        moveAllToJoignableThreads()
        lock.withLock {
            idleThreadsCondition.signal()
        }
    }

    private fun joinAllThreads() = synchronized(joignableThreads) {
        joignableThreads.forEach {
            it.stopWhenPermitted()
            it.join()
        }
    }

    private fun moveAllToJoignableThreads() = synchronized(activeThreads) {
        activeThreads.toTypedArray().forEach {
            moveToJoignableThreads(it)
        }
    }

    private fun moveToJoignableThreads(actorThread: ActorThread) = synchronized(activeThreads) {
        synchronized(joignableThreads) {
            activeThreads -= actorThread
            joignableThreads += actorThread
        }
    }
}

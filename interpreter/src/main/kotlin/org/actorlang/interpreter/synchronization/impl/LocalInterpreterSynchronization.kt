package org.actorlang.interpreter.synchronization.impl

import org.actorlang.actorsystem.events.ActorThreadExceptionEvent
import org.actorlang.actorsystem.events.AllLocalActorThreadsTimedOutEvent
import org.actorlang.actorsystem.events.Event
import org.actorlang.actorsystem.events.EventListener
import org.actorlang.interpreter.synchronization.InterpreterExitReason
import org.actorlang.interpreter.synchronization.InterpreterSynchronization
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class LocalInterpreterSynchronization : InterpreterSynchronization, EventListener {
    private val exitLock = ReentrantLock()
    private val exitCondition = exitLock.newCondition()

    private val mustExit
        get() = exitReason != null

    override var exitReason: InterpreterExitReason? = null
        private set

    override fun waitForExitCondition() {
        exitLock.withLock {
            if (!mustExit) {
                exitCondition.await()
            }
        }
    }

    override fun onEvent(event: Event) {
        when (event) {
            is AllLocalActorThreadsTimedOutEvent -> allActorThreadsTimedOut()
            is ActorThreadExceptionEvent -> actorThreadException(event.exception)
        }
    }

    private fun allActorThreadsTimedOut() {
        exitLock.withLock {
            exitReason = AllLocalActorThreadsTimedOutExitReason
            exitCondition.signal()
        }
    }

    private fun actorThreadException(e: Throwable) {
        exitLock.withLock {
            exitReason = ActorThreadExceptionExitReason(e)
            exitCondition.signal()
        }
    }
}

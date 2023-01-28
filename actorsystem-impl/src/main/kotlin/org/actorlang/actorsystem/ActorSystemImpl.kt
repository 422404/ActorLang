package org.actorlang.actorsystem

import org.actorlang.actorsystem.events.ActorThreadEventListener
import org.actorlang.actorsystem.events.ActorThreadExceptionEvent
import org.actorlang.actorsystem.events.AllLocalActorThreadsTimedOutEvent
import org.actorlang.actorsystem.events.EventListener
import org.actorlang.actorsystem.exception.ActorAlreadyRegisteredInActorSystem
import org.actorlang.actorsystem.exception.ActorNotRegisteredInActorSystem
import org.actorlang.actorsystem.exception.NoActorStateException
import org.actorlang.actorsystem.messaging.MailboxFactory
import org.actorlang.actorsystem.messaging.MessagingServer
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ActorSystemImpl(
    override val messagingServer: MessagingServer,
    private val actorFactory: ActorFactory,
    private val actorThreadFactory: ActorThreadFactory,
    private val mailboxFactory: MailboxFactory,
    private val eventListener: EventListener
) : ActorSystem, ActorThreadEventListener {

    private val stateLock = ReentrantLock()
    private var state = ServerLikeState.CREATED
    private val aliveActors = ConcurrentLinkedQueue<Actor>()
    private val actorStates = ConcurrentHashMap<Actor, ActorState>()
    private val runningActorThreadsLock = ReentrantLock()
    private val runningActorThreads = mutableMapOf<Actor, ActorThread>()
    private val executorService = Executors.newCachedThreadPool()

    override val actorAwakener = object : ActorAwakener {
        override fun isActorAwake(actor: Actor): Boolean {
            if (!isActorAlive(actor)) {
                throw ActorNotRegisteredInActorSystem(actor)
            }

            return runningActorThreadsLock.withLock {
                runningActorThreads.containsKey(actor)
            }
        }

        override fun wakeActorUp(actor: Actor) {
            if (!isActorAlive(actor)) {
                throw ActorNotRegisteredInActorSystem(actor)
            }

            runningActorThreadsLock.withLock {
                // The lock is reentrant, so we do not deadlock when calling isActorAwake()
                if (!isActorAwake(actor)) {
                    val actorThread = actorThreadFactory.createActorThread(
                        actor,
                        this@ActorSystemImpl, this@ActorSystemImpl
                    )
                    runningActorThreads[actor] = actorThread
                    executorService.execute(actorThread)
                }
            }
        }
    }

    override fun registerActor(actor: Actor) {
        if (isActorAlive(actor)) {
            throw ActorAlreadyRegisteredInActorSystem(actor)
        }
        aliveActors.add(actor)
    }

    override fun createActorWithState(actorState: ActorState) = actorFactory.createActor().also {
        registerActor(it)
        bindActorToNewActorState(it, actorState)
        messagingServer.registerMailbox(it.ref, mailboxFactory.createMailbox(this, it))
        actorAwakener.wakeActorUp(it)
    }

    override fun bindActorToNewActorState(actor: Actor, newActorState: ActorState) {
        if (!isActorAlive(actor)) {
            throw ActorNotRegisteredInActorSystem(actor)
        }
        actorStates[actor] = newActorState
        newActorState.onBind(actor)
    }

    override fun getActorState(actor: Actor): ActorState {
        if (!isActorAlive(actor)) {
            throw ActorNotRegisteredInActorSystem(actor)
        }
        return actorStates[actor] ?: throw NoActorStateException(actor)
    }

    override fun isActorAlive(actor: Actor) = aliveActors.contains(actor)

    override fun killActor(actor: Actor) {
        if (!isActorAlive(actor)) {
            throw ActorNotRegisteredInActorSystem(actor)
        }
        aliveActors.remove(actor)
    }

    override fun onActorThreadExit(actor: Actor) {
        runningActorThreadsLock.withLock {
            runningActorThreads.remove(actor)

            if (runningActorThreads.isEmpty()) {
                eventListener.onEvent(AllLocalActorThreadsTimedOutEvent)
            }
        }
    }

    override fun onActorThreadException(e: Throwable) {
        eventListener.onEvent(ActorThreadExceptionEvent(e))
    }

    override fun start() {
        stateLock.withLock {
            if (state == ServerLikeState.CREATED) {
                state = ServerLikeState.STARTED
                messagingServer.start()
            }
        }
    }

    override fun shutdown(timeoutMillis: Long) {
        stateLock.withLock {
            if (state == ServerLikeState.STARTED) {
                state = ServerLikeState.STOPPED
                executorService.shutdown()
                executorService.awaitTermination(timeoutMillis / 2, TimeUnit.MILLISECONDS)
                messagingServer.shutdown(timeoutMillis / 2)
            }
        }
    }
}

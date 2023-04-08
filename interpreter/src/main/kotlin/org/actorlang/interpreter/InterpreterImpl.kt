package org.actorlang.interpreter

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.actorsystem.ServerLikeState
import org.actorlang.interpreter.eval.RootEvaluator
import org.actorlang.interpreter.synchronization.InterpreterExitReason
import org.actorlang.interpreter.synchronization.InterpreterSynchronization
import org.actorlang.parser.ParserFactory
import java.io.PrintStream
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class InterpreterImpl(
    private val actorSystem: ActorSystem,
    stdout: PrintStream,
    private val parserFactory: ParserFactory,
    private val interpreterSynchronization: InterpreterSynchronization
) : Interpreter {

    private val context = Context.of(stdout)
    private val stateLock = ReentrantLock()
    private var state = ServerLikeState.CREATED

    override fun run(source: String, sourceName: String): InterpreterExitReason {
        // Parse and evaluate the code
        val parser = parserFactory.createParser()
        val rootNode = parser.parse(source, sourceName)
        RootEvaluator(context, actorSystem).evaluateRoot(rootNode)
        // Wait for an exit condition (normal or erroneous)
        interpreterSynchronization.waitForExitCondition()

        return interpreterSynchronization.exitReason!!
    }

    override fun start() {
        stateLock.withLock {
            if (state == ServerLikeState.CREATED) {
                state = ServerLikeState.STARTED
                actorSystem.start()
            }
        }
    }

    override fun shutdown(timeoutMillis: Long) {
        stateLock.withLock {
            if (state == ServerLikeState.STARTED) {
                state = ServerLikeState.STOPPED
                actorSystem.shutdown(timeoutMillis)
            }
        }
    }
}

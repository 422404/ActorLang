package org.actorlang.interpreter

import org.actorlang.actorsystem.ActorFactoryImpl
import org.actorlang.actorsystem.ActorSystemImpl
import org.actorlang.actorsystem.ActorThreadFactoryImpl
import org.actorlang.actorsystem.messaging.LocalMessagingServer
import org.actorlang.actorsystem.messaging.MailboxFactoryImpl
import org.actorlang.interpreter.synchronization.impl.LocalInterpreterSynchronization
import org.actorlang.parser.impl.AntlrParserFactory
import java.io.PrintStream

private const val ACTOR_THREAD_TIMEOUT_MS = 50L

/**
 * A factory to create already configured interpreters.
 */
class InterpreterFactoryImpl : InterpreterFactory {

    override fun createDefaultInterpreter(): Interpreter {
        return createDefaultInterpreter(System.out)
    }

    override fun createDefaultInterpreter(stdout: PrintStream): Interpreter {
        val messagingServer = LocalMessagingServer()
        val actorFactory = ActorFactoryImpl()
        val actorThreadFactory = ActorThreadFactoryImpl(ACTOR_THREAD_TIMEOUT_MS)
        val mailboxFactory = MailboxFactoryImpl()
        val localInterpreterSynchronization = LocalInterpreterSynchronization()

        val actorSystem = ActorSystemImpl(
            messagingServer,
            actorFactory,
            actorThreadFactory,
            mailboxFactory,
            localInterpreterSynchronization
        )
        val parserFactory = AntlrParserFactory()

        return InterpreterImpl(actorSystem, stdout, parserFactory, localInterpreterSynchronization)
    }
}

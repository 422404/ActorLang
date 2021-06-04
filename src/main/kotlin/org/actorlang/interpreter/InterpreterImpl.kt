package org.actorlang.interpreter

import org.actorlang.ast.printer.AstPrettyPrinter
import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.eval.RootEvaluator
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.parser.Parser
import java.io.PrintStream

class InterpreterImpl(
    configuration: Configuration,
    out: PrintStream,
    communicationsSender: CommunicationsSender,
    communicationsBinder: CommunicationsBinder,
    scheduler: Scheduler,
    val parser: Parser
) : Interpreter {
    private val context = Context(
        configuration,
        out,
        communicationsSender,
        communicationsBinder,
        scheduler
    ).also {
        communicationsSender.setContext(it)
        communicationsBinder.setContext(it)
    }

    private lateinit var rootEvaluator: RootEvaluator

    override fun run(source: String, sourceName: String) {
        val rootNode = parser.parse(source, sourceName)
        if (context.configuration.debug) {
            AstPrettyPrinter(rootNode, 2).printAst()
            println()
        }
        rootEvaluator = RootEvaluator(context)
        rootEvaluator.evaluateRoot(rootNode)
        context.scheduler.join()
    }
}

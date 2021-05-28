package org.actorlang.interpreter

import org.actorlang.ast.printer.AstPrettyPrinter
import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.eval.RootEvaluator
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.parser.impl.AntlrParser
import java.io.PrintStream

class InterpreterImpl(
    configuration: Configuration,
    out: PrintStream,
    communicationsSender: CommunicationsSender,
    communicationsBinder: CommunicationsBinder,
    scheduler: Scheduler
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
        val parser = AntlrParser(sourceName)
        val rootNode = parser.parse(source)
        if (context.configuration.debug) {
            AstPrettyPrinter(rootNode, 2).printAst()
            println()
        }
        rootEvaluator = RootEvaluator(context)
        rootEvaluator.evaluateRoot(rootNode)
        context.scheduler.join()
    }
}

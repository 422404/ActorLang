package org.actorlang.interpreter

import org.actorlang.ast.printer.AstPrettyPrinter
import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.eval.RootEvaluator
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.interpreter.scheduler.SchedulerSynchronization
import org.actorlang.parser.ParserFactory
import java.io.PrintStream

class InterpreterImpl(
    configuration: Configuration,
    out: PrintStream,
    communicationsSender: CommunicationsSender,
    communicationsBinder: CommunicationsBinder,
    scheduler: Scheduler,
    schedulerSynchronization: SchedulerSynchronization,
    private val parserFactory: ParserFactory
) : Interpreter {
    private val context = ContextImpl(
        configuration,
        out,
        communicationsSender,
        communicationsBinder,
        scheduler,
        schedulerSynchronization
    ).also {
        communicationsSender.setContext(it)
        communicationsBinder.setContext(it)
    }

    private lateinit var rootEvaluator: RootEvaluator

    override fun run(source: String, sourceName: String) {
        val parser = parserFactory.createParser()
        val rootNode = parser.parse(source, sourceName)
        if (context.configuration.debug) {
            AstPrettyPrinter(rootNode, 2).printAst()
            println()
        }
        rootEvaluator = RootEvaluator(context)
        try {
            rootEvaluator.evaluateRoot(rootNode)
        } finally {
            context.scheduler.join()
        }
    }
}

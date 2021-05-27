package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.eval.RootEvaluator
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.parser.impl.AntlrParser
import java.io.File
import java.io.PrintStream

class InterpreterImpl(
    configuration: Configuration,
    out: PrintStream,
    communicationsSender: CommunicationsSender,
    communicationsBinder: CommunicationsBinder,
    scheduler: Scheduler
): Interpreter {
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

    override fun run(source: String, filePath: String) {
        val parser = AntlrParser(filePath)
        val rootNode = parser.parse(source)
        rootEvaluator = RootEvaluator(context)
        rootEvaluator.evaluateRoot(rootNode)
        context.scheduler.join()
    }

    override fun run(file: File) {
        TODO("Not yet implemented")
    }
}

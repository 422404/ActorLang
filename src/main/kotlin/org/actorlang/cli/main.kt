package org.actorlang.cli

import mu.KotlinLogging
import org.actorlang.actorsystem.scoped
import org.actorlang.interpreter.Interpreter
import org.actorlang.interpreter.InterpreterFactoryImpl
import org.actorlang.interpreter.exception.ActorLangRuntimeException
import java.io.BufferedReader
import java.io.File
import kotlin.system.exitProcess

private val logger = KotlinLogging.logger {}

fun main(vararg args: String) {
    val result = if (args.size != 1) {
        printUsage()
        -1
    } else {
        val file = File(args[0])
        val fileContent = readInputFile(file)
        if (fileContent == null) {
            println("Cannot read file content.")
            -1
        } else {
            execute(fileContent, file.absolutePath)
        }
    }
    exitProcess(result)
}

private fun printUsage() {
    println("No file path provided. Please provide one.")
}

private fun readInputFile(file: File): String? {
    return try {
        file.bufferedReader().use(BufferedReader::readText)
    } catch (e: Exception) {
        null
    }
}

private fun execute(code: String, sourceName: String): Int {
    var result = 0

    val interpreter = InterpreterFactoryImpl().createDefaultInterpreter()

    try {
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(code, sourceName)
        }
    } catch (e: ActorLangRuntimeException) {
        logger.error(formatApplicativeExceptionMessage(e))
        result = -1
    } catch (e: Exception) {
        logger.error("Unhandled exception", e)
        result = -1
    }

    return result
}

private fun formatApplicativeExceptionMessage(exception: ActorLangRuntimeException): String {
    val sourceName = exception.sourcePosition.sourceName
    val column = exception.sourcePosition.column
    val line = exception.sourcePosition.line
    val msg = exception.message
    return "$sourceName:$line,$column : $msg"
}

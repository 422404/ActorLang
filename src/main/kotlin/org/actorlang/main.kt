package org.actorlang

import org.actorlang.config.Configuration
import org.actorlang.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.InterpreterImpl
import org.actorlang.interpreter.comms.CommunicationsManager
import org.actorlang.interpreter.scheduler.SchedulerImpl
import org.actorlang.parser.impl.AntlrParserFactory
import java.io.BufferedReader
import java.io.File
import kotlin.system.exitProcess

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

private fun execute(code: String, sourceName: String): Int {
    var result = 0
    val config = Configuration().apply {
        // debug = true
        // messageDuplicates = true
        // duplicationChances = 0.5f
        // outOfOrderMessages = true
    }
    val communicationsManager = CommunicationsManager()
    val scheduler = SchedulerImpl()
    val parserFactory = AntlrParserFactory()
    val interpreter = InterpreterImpl(
        config,
        System.out,
        communicationsManager,
        communicationsManager,
        scheduler,
        scheduler,
        parserFactory
    )

    println("---- start system ----")
    try {
        interpreter.run(code, sourceName)
    } catch (e: ActorLangRuntimeException) {
        println(e.message)
        result = -1
    } catch (e: Exception) {
        e.printStackTrace()
        result = -1
    }
    println("---- stop system -----")

    return result
}

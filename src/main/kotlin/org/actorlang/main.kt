package org.actorlang

import org.actorlang.config.Configuration
import org.actorlang.interpreter.InterpreterImpl
import org.actorlang.interpreter.comms.CommunicationsManager
import org.actorlang.interpreter.scheduler.SchedulerImpl
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
    val config = Configuration().apply {
        // debug = true
        // messageDuplicates = true
        // duplicationChances = 0.5f
        // outOfOrderMessages = true
    }
    val communicationsManager = CommunicationsManager()
    val scheduler = SchedulerImpl()
    val interpreter = InterpreterImpl(
        config,
        System.out,
        communicationsManager,
        communicationsManager,
        scheduler
    )

    println("---- start system ----")
    interpreter.run(code, sourceName)
    println("---- stop system -----")

    return 0
}

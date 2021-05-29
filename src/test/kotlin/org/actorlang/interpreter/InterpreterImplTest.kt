package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.scheduler.Scheduler
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import java.io.PrintStream
import kotlin.test.assertContentEquals

internal class InterpreterImplTest {
    private lateinit var config: Configuration
    private lateinit var printStream: PrintStream
    private lateinit var communicationsBinder: CommunicationsBinder
    private lateinit var communicationsSender: CommunicationsSender
    private lateinit var scheduler: Scheduler
    private lateinit var interpreter: Interpreter

    private val printedObjects = mutableListOf<Any>()

    @BeforeEach
    fun setup() {
        printedObjects.clear()
        config = Configuration()
        communicationsBinder = mock()
        communicationsSender = mock()
        scheduler = mock()
        printStream = mock {
            on {
                println(any<Any>())
            } doAnswer {
                printedObjects += it.arguments[0]
            }
        }
        interpreter = InterpreterImpl(
            config,
            printStream,
            communicationsSender,
            communicationsBinder,
            scheduler
        )
    }

    @Test
    fun `For loop iterate in an increasing range`() {
        interpreter.run(
            """
            for (i in 1..10) {
                display i;
            }
            """.trimIndent(),
            "<test>"
        )
        assertContentEquals(1..10, printedObjects)
    }

    @Test
    fun `For loop iterate in a decreasing range`() {
        interpreter.run(
            """
            for (i in 10..1) {
                display i;
            }
            """.trimIndent(),
            "<test>"
        )
        assertContentEquals(10 downTo 1, printedObjects)
    }

    @Test
    fun `Cannot create a range with objects that are not integers`() {
        assertThrows<ActorLangRuntimeException> {
            interpreter.run(
                """
                for (i in "hello".."world!") {
                    display i;
                }
                """.trimIndent(),
                "<test>"
            )
        }
    }
}

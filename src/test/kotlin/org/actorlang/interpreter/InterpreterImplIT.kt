package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsManager
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.interpreter.scheduler.SchedulerImpl
import org.actorlang.interpreter.scheduler.SchedulerSynchronization
import org.actorlang.parser.impl.AntlrParserFactory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import java.io.PrintStream
import kotlin.test.assertContains
import kotlin.test.assertContentEquals

class InterpreterImplIT {

    private data class InterpreterAndPrintedObjects(
        val interpreter: Interpreter,
        val printedObjects: MutableList<Any>
    )

    /**
     * Creates an interpreter with mocked scheduler and communications.
     * The «out» PrintStream is a fake object «printing» into a list in which
     * items can be retrieved so we can assert the good execution of the program.
     */
    private fun createInterpreterWithoutActorCapabilities(): InterpreterAndPrintedObjects {
        val printedObjects = mutableListOf<Any>()
        val config = Configuration().apply { debug = false }
        val communicationsBinder = mock<CommunicationsBinder>()
        val communicationsSender = mock<CommunicationsSender>()
        val scheduler = mock<Scheduler>()
        val schedulerSynchronization = mock<SchedulerSynchronization>()
        val printStream = mock<PrintStream> {
            on {
                println(any<Any>())
            } doAnswer {
                printedObjects += it.arguments[0]
            }
        }
        val parserFactory = AntlrParserFactory()
        val interpreter = InterpreterImpl(
            config,
            printStream,
            communicationsSender,
            communicationsBinder,
            scheduler,
            schedulerSynchronization,
            parserFactory
        )
        return InterpreterAndPrintedObjects(interpreter, printedObjects)
    }

    /**
     * Creates an interpreter.
     * The «out» PrintStream is a fake object «printing» into a list in which
     * items can be retrieved so we can assert the good execution of the program.
     */
    private fun createDefaultInterpreter(): InterpreterAndPrintedObjects {
        val printedObjects = mutableListOf<Any>()
        val config = Configuration().apply { debug = false }
        val communicationsManager = CommunicationsManager()
        val scheduler = SchedulerImpl()
        val printStream = mock<PrintStream> {
            on {
                println(any<Any>())
            } doAnswer {
                printedObjects += it.arguments[0]
            }
        }
        val parserFactory = AntlrParserFactory()
        val interpreter = InterpreterImpl(
            config,
            printStream,
            communicationsManager,
            communicationsManager,
            scheduler,
            scheduler,
            parserFactory
        )
        return InterpreterAndPrintedObjects(interpreter, printedObjects)
    }

    @Test
    fun `For loop iterate in an increasing range`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
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
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
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
        val (interpreter, _) = createInterpreterWithoutActorCapabilities()
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

    @Test
    fun `Toplevel variables can be accessed in behaviors`() {
        val (interpreter, printedObjects) = createDefaultInterpreter()
        val value = 42
        interpreter.run(
            """
            Actor () ["hello"] = display toplevelVar;

            a = create Actor ();
            toplevelVar = $value;
            send ["hello"] to a
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, value)
    }
}

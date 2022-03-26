package org.actorlang.interpreter

import org.actorlang.config.Configuration
import org.actorlang.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsManager
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.exceptions.WrongFunctionArityException
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
import kotlin.test.assertTrue

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

            on {
                print(any<Any>())
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

            on {
                print(any<Any>())
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

    @Test
    fun `Adding two integers makes an integer`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.run(
            """
            display 2 + 2 - 1
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, 3)
    }

    @Test
    fun `Adding an integer and a boolean is not permitted`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()

        assertThrows<ActorLangRuntimeException> {
            interpreter.run(
                """
                display 10 + true
                """.trimIndent(),
                "<test>"
            )
        }
        assertTrue(printedObjects.isEmpty())
    }

    @Test
    fun `Adding two strings concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string1 = "Hello,"
        val string2 = "world!"
        interpreter.run(
            """
            display "$string1" + "$string2"
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, "$string1$string2")
    }

    @Test
    fun `Adding a string with an integer concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string = "Hello "
        val integer = 42
        interpreter.run(
            """
            display "$string" + $integer
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, "$string$integer")
    }

    @Test
    fun `Adding a boolean with a string concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string = " indeed..."
        val boolean = true
        interpreter.run(
            """
            display $boolean + "$string"
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, "$boolean$string")
    }

    @Test
    fun `Put statement prints a value`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 1337
        interpreter.run(
            """
            put $value
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, value)
    }

    @Test
    fun `Commented code is not executed`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.run(
            """
            /*
            display 42
            */
            """.trimIndent(),
            "<test>"
        )
        assertTrue(printedObjects.isEmpty())
    }

    @Test
    fun `A previously defined function can be called`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 3
        interpreter.run(
            """
            fun F(x) = x * x;
            
            display F($value)
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, value * value)
    }

    @Test
    fun `A function returns on its first executed return statement`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 314
        interpreter.run(
            """
            fun F() = {
                return $value;
                return 1337;
                return 42
            };
            
            display F()
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, value)
    }

    @Test
    fun `Function arity is checked (right arity)`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value1 = 123
        val value2 = 321
        interpreter.run(
            """
            fun F(a, b) = a + b;
            
            display F($value1, $value2)
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, value1 + value2)
    }

    @Test
    fun `Function arity is checked (wrong arity)`() {
        val (interpreter, _) = createInterpreterWithoutActorCapabilities()
        assertThrows<WrongFunctionArityException> {
            interpreter.run(
                """
                fun F(a, b) = a + b;
                
                display F(123)
                """.trimIndent(),
                "<test>"
            )
        }
    }

    @Test
    fun `Functions can be recursive`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.run(
            """
            fun fact(n) =
                if (n < 2) {
                    return 1
                } else {
                    return n * fact(n - 1)
                };
            
            display fact(5)
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, 120)
    }

    @Test
    fun `Functions with no 'return' statement implicitly return Unit`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.run(
            """
            fun F() = {};
            
            display F()
            """.trimIndent(),
            "<test>"
        )
        assertContains(printedObjects, Unit)
    }
}

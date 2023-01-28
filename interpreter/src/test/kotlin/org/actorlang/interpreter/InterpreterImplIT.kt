package org.actorlang.interpreter

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.actorsystem.scoped
import org.actorlang.interpreter.exception.ActorLangRuntimeException
import org.actorlang.interpreter.exception.WrongFunctionArityException
import org.actorlang.interpreter.synchronization.InterpreterExitReason
import org.actorlang.interpreter.synchronization.InterpreterSynchronization
import org.actorlang.interpreter.synchronization.impl.AllLocalActorThreadsTimedOutExitReason
import org.actorlang.parser.impl.AntlrParserFactory
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class InterpreterImplIT {
    private data class InterpreterWithoutActorCapabilities(
        val interpreter: Interpreter,
        val printedObjects: MutableList<Any>
    )

    private data class DefaultInterpreter(
        val interpreter: Interpreter,
        val printedObjects: MutableList<Any>
    )

    /**
     * Creates an interpreter with mocked scheduler and communications.
     * The stdout [PrintStream] is a fake object printing into a list in which
     * items can be retrieved so that we can assert the good execution of the program.
     */
    private fun createInterpreterWithoutActorCapabilities(): InterpreterWithoutActorCapabilities {
        val printedObjects = mutableListOf<Any>()
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
        val actorSystem = mock<ActorSystem> {
            on { messagingServer } doReturn mock()
        }
        val interpreterSynchronization = mock<InterpreterSynchronization> {
            on { exitReason } doReturn mock()
        }
        val interpreter = InterpreterImpl(
            actorSystem,
            printStream,
            parserFactory,
            interpreterSynchronization
        )
        return InterpreterWithoutActorCapabilities(interpreter, printedObjects)
    }

    /**
     * Creates an interpreter.
     * The stdout [PrintStream] is a fake object printing into a list in which
     * items can be retrieved so that we can assert the good execution of the program.
     */
    private fun createDefaultInterpreter(): DefaultInterpreter {
        val printedObjects = mutableListOf<Any>()
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
        val interpreter = InterpreterFactoryImpl().createDefaultInterpreter(printStream)
        return DefaultInterpreter(interpreter, printedObjects)
    }

    @Test
    fun `For loop iterate in an increasing range`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                for (i in 1..10) {
                    display i;
                }
                """.trimIndent(),
                "<test>"
            )
        }
        assertContentEquals(1..10, printedObjects)
    }

    @Test
    fun `For loop iterate in a decreasing range`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                for (i in 10..1) {
                    display i;
                }
                """.trimIndent(),
                "<test>"
            )
        }
        assertContentEquals(10 downTo 1, printedObjects)
    }

    @Test
    fun `Cannot create a range with objects that are not integers`() {
        val (interpreter, _) = createInterpreterWithoutActorCapabilities()
        assertFailsWith<ActorLangRuntimeException> {
            interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
                run(
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

    @Test
    fun `Toplevel variables can be accessed in behaviors`() {
        val (interpreter, printedObjects) = createDefaultInterpreter()
        val value = 42
        lateinit var exitReason: InterpreterExitReason

        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            exitReason = run(
                """
                Actor () ["hello"] = display toplevelVar;

                a = create Actor ();
                toplevelVar = $value;
                send ["hello"] to a
                """.trimIndent(),
                "<test>"
            )
        }

        assertContains(printedObjects, value)
        assertEquals(AllLocalActorThreadsTimedOutExitReason, exitReason)
    }

    @Test
    fun `Adding two integers makes an integer`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                display 2 + 2 - 1
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, 3)
    }

    @Test
    fun `Adding an integer and a boolean is not permitted`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()

        assertFailsWith<ActorLangRuntimeException> {
            interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
                run(
                    """
                    display 10 + true
                    """.trimIndent(),
                    "<test>"
                )
            }
        }
        assertTrue(printedObjects.isEmpty())
    }

    @Test
    fun `Adding two strings concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string1 = "Hello,"
        val string2 = "world!"
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                display "$string1" + "$string2"
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, "$string1$string2")
    }

    @Test
    fun `Adding a string with an integer concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string = "Hello "
        val integer = 42
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                display "$string" + $integer
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, "$string$integer")
    }

    @Test
    fun `Adding a boolean with a string concatenates them`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val string = " indeed..."
        val boolean = true
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                display $boolean + "$string"
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, "$boolean$string")
    }

    @Test
    fun `Put statement prints a value`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 1337
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                put $value
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, value)
    }

    @Test
    fun `Commented code is not executed`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                /*
                display 42
                */
                """.trimIndent(),
                "<test>"
            )
        }
        assertTrue(printedObjects.isEmpty())
    }

    @Test
    fun `A previously defined function can be called`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 3
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                fun F(x) = x * x;
                
                display F($value)
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, value * value)
    }

    @Test
    fun `A function returns on its first executed return statement`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value = 314
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
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
        }
        assertContains(printedObjects, value)
    }

    @Test
    fun `Function arity is checked (right arity)`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val value1 = 123
        val value2 = 321
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                fun F(a, b) = a + b;
                
                display F($value1, $value2)
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, value1 + value2)
    }

    @Test
    fun `Function arity is checked (wrong arity)`() {
        val (interpreter, _) = createInterpreterWithoutActorCapabilities()
        assertFailsWith<WrongFunctionArityException> {
            interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
                run(
                    """
                    fun F(a, b) = a + b;
                    
                    display F(123)
                    """.trimIndent(),
                    "<test>"
                )
            }
        }
    }

    @Test
    fun `Functions can be recursive`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
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
        }
        assertContains(printedObjects, 120)
    }

    @Test
    fun `Functions with no 'return' statement implicitly return Unit`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                fun F() = {};
                
                display F()
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, Unit)
    }

    @Test
    fun `Functions can be called with 'call' to discard their return value`() {
        val (interpreter, printedObjects) = createInterpreterWithoutActorCapabilities()
        val text = "Hello there"
        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            run(
                """
                fun greet() = {
                    display "$text"
                };
                
                call greet()
                """.trimIndent(),
                "<test>"
            )
        }
        assertContains(printedObjects, text)
    }

    @Test
    fun `An actor can become another actor type`() {
        val (interpreter, printedObjects) = createDefaultInterpreter()
        lateinit var exitReason: InterpreterExitReason

        interpreter.scoped(Interpreter.SHUTDOWN_TIMEOUT_MS) {
            exitReason = run(
                """
                Adder (X, Notifier) ["add", value] = {
                    newValue = X + value;
                    send [newValue] to Notifier;
                    become Adder(newValue, Notifier)
                };
                
                Printer () [value] = display value;
                
                Notifier0 (Printer) [value] = become Notifier1(Printer);
                Notifier1 (Printer) [value] = send [value] to Printer;
                
                printer = create Printer();
                notifier = create Notifier0(printer);
                adder = create Adder(0, notifier);
                
                send ["add", 21] to adder;
                send ["add", 21] to adder;
                """.trimIndent(),
                "<test>"
            )
        }

        assertContains(printedObjects, 42)
        assertEquals(AllLocalActorThreadsTimedOutExitReason, exitReason)
    }
}

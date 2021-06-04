package org.actorlang.interpreter

import org.actorlang.ast.RootNode
import org.actorlang.config.Configuration
import org.actorlang.interpreter.comms.CommunicationsBinder
import org.actorlang.interpreter.comms.CommunicationsSender
import org.actorlang.interpreter.exceptions.ActorLangRuntimeException
import org.actorlang.interpreter.scheduler.Scheduler
import org.actorlang.parser.Parser
import org.actorlang.parser.ParserFactory
import org.actorlang.parser.Position
import org.actorlang.parser.impl.AntlrParserFactory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.io.PrintStream
import kotlin.test.assertContentEquals

internal class InterpreterImplTest {
    private lateinit var config: Configuration
    private lateinit var printStream: PrintStream
    private lateinit var communicationsBinder: CommunicationsBinder
    private lateinit var communicationsSender: CommunicationsSender
    private lateinit var scheduler: Scheduler
    private lateinit var interpreter: Interpreter
    private lateinit var parserFactory: ParserFactory

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
        parserFactory = AntlrParserFactory()
        interpreter = InterpreterImpl(
            config,
            printStream,
            communicationsSender,
            communicationsBinder,
            scheduler,
            parserFactory
        )
    }

    private data class StubbedParserFactoryAndParser(
        val parserFactory: ParserFactory,
        val parser: Parser
    )

    private fun createStubbedParserFactoryAndParser(): StubbedParserFactoryAndParser {
        val rootNode = RootNode(
            Position(1, 1, "test"),
            Position(1, 1, "test"),
            arrayOf()
        )
        val parserStub = mock<Parser>() {
            on {
                parse(any<String>(), any<String>())
            } doReturn(rootNode)
        }
        val parserFactoryStub = mock<ParserFactory>() {
            on {
                createParser()
            } doReturn(parserStub)
        }
        return StubbedParserFactoryAndParser(parserFactoryStub, parserStub)
    }

    @Test
    fun `Calls ParserFactory#createParser`() {
        val stubbedParserFactoryAndParser = createStubbedParserFactoryAndParser()
        val interpreter = InterpreterImpl(
            configuration = Configuration().apply { debug = false },
            out = mock(),
            communicationsSender = mock(),
            communicationsBinder = mock(),
            scheduler = mock(),
            stubbedParserFactoryAndParser.parserFactory
        )

        interpreter.run("", "test")
        verify(stubbedParserFactoryAndParser.parserFactory).createParser()
    }

    @Test
    fun `Calls Parser#parse`() {
        val stubbedParserFactoryAndParser = createStubbedParserFactoryAndParser()
        val interpreter = InterpreterImpl(
            configuration = Configuration().apply { debug = false },
            out = mock(),
            communicationsSender = mock(),
            communicationsBinder = mock(),
            scheduler = mock(),
            stubbedParserFactoryAndParser.parserFactory
        )

        interpreter.run("", "test")
        verify(stubbedParserFactoryAndParser.parser).parse(any<String>(), any<String>())
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

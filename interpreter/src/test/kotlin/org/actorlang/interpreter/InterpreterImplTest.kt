package org.actorlang.interpreter

import org.actorlang.actorsystem.ActorSystem
import org.actorlang.ast.RootNode
import org.actorlang.interpreter.synchronization.InterpreterSynchronization
import org.actorlang.parser.Parser
import org.actorlang.parser.ParserFactory
import org.actorlang.parser.Position
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.Test

class InterpreterImplTest {
    private data class StubbedParserFactoryAndParser(
        val parserFactory: ParserFactory,
        val parser: Parser
    )

    /**
     * Creates a stubbed ParserFactory returning a stubbed Parser instance.
     */
    private fun createStubbedParserFactoryAndParser(): StubbedParserFactoryAndParser {
        val rootNode = RootNode(
            Position(1, 1, "test"),
            Position(1, 1, "test"),
            arrayOf()
        )
        val parserStub = mock<Parser> {
            on { parse(any(), any()) } doReturn rootNode
        }
        val parserFactoryStub = mock<ParserFactory> {
            on { createParser() } doReturn parserStub
        }
        return StubbedParserFactoryAndParser(parserFactoryStub, parserStub)
    }

    private fun createStubbedActorSystem(): ActorSystem {
        val actorSystem = mock<ActorSystem> {
            on { messagingServer } doReturn mock()
        }
        return actorSystem
    }

    private fun createStubbedInterpreterSynchronization(): InterpreterSynchronization {
        val interpreterSynchronization = mock<InterpreterSynchronization> {
            on { exitReason } doReturn mock()
        }
        return interpreterSynchronization
    }

    @Test
    fun `Run calls ParserFactory#createParser`() {
        val stubbedParserFactoryAndParser = createStubbedParserFactoryAndParser()
        val actorSystem = createStubbedActorSystem()
        val interpreterSynchronization = createStubbedInterpreterSynchronization()
        val interpreter = InterpreterImpl(
            actorSystem,
            mock(),
            stubbedParserFactoryAndParser.parserFactory,
            interpreterSynchronization
        )

        interpreter.run("", "test")
        verify(stubbedParserFactoryAndParser.parserFactory).createParser()
    }

    @Test
    fun `Run calls Parser#parse`() {
        val stubbedParserFactoryAndParser = createStubbedParserFactoryAndParser()
        val actorSystem = createStubbedActorSystem()
        val interpreterSynchronization = createStubbedInterpreterSynchronization()
        val interpreter = InterpreterImpl(
            actorSystem,
            mock(),
            stubbedParserFactoryAndParser.parserFactory,
            interpreterSynchronization
        )

        interpreter.run("", "test")
        verify(stubbedParserFactoryAndParser.parser).parse(any(), any())
    }
}

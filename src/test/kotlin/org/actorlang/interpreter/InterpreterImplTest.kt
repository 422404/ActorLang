package org.actorlang.interpreter

import org.actorlang.ast.RootNode
import org.actorlang.config.Configuration
import org.actorlang.parser.Parser
import org.actorlang.parser.ParserFactory
import org.actorlang.parser.Position
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class InterpreterImplTest {

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
            on {
                parse(any(), any())
            } doReturn(rootNode)
        }
        val parserFactoryStub = mock<ParserFactory> {
            on {
                createParser()
            } doReturn(parserStub)
        }
        return StubbedParserFactoryAndParser(parserFactoryStub, parserStub)
    }

    @Test
    fun `Run calls ParserFactory#createParser`() {
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
    fun `Run calls Parser#parse`() {
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
        verify(stubbedParserFactoryAndParser.parser).parse(any(), any())
    }
}

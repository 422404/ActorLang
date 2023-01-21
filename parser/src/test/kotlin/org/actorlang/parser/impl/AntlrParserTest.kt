package org.actorlang.parser.impl

import org.actorlang.parser.Parser
import org.actorlang.parser.exceptions.SyntaxError
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class AntlrParserTest {
    private lateinit var parser: Parser

    @BeforeEach
    fun setup() {
        parser = AntlrParserFactory().createParser()
    }

    @Test
    fun `Nodes line and column both start at 1`() {
        val rootNode = parser.parse("a = 42", "<test>")
        assertEquals(1, rootNode.startPosition.line)
        assertEquals(1, rootNode.startPosition.column)
    }

    @Test
    fun `The node's start and end positions have the same source name as the one given to the parser`() {
        val sourceName = "<the-source-name>"
        val rootNode = parser.parse("a = 42", sourceName)
        assertEquals(sourceName, rootNode.startPosition.sourceName)
        assertEquals(sourceName, rootNode.endPosition.sourceName)
    }

    @Test
    fun `Syntax errors are reported with the error position`() {
        assertThrows<SyntaxError> {
            parser.parse("fun isn't() = it?", "<test>")
        }
    }

    @Test
    fun `Can parse assignment`() {
        val rootNode = parser.parse("a = 42", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse 'diplay' statements`() {
        val rootNode = parser.parse("display \"hello\"", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse 'put' statements`() {
        val rootNode = parser.parse("put 1337", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse 'send' statements with 'self' references`() {
        val rootNode = parser.parse("send [\"nice\", 1337, self] to NiceActor", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse 'call' statements`() {
        val rootNode = parser.parse("call F(x, y)", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse 'for' statements`() {
        val rootNode = parser.parse(
            """
            for (i in 0..10) {
                display i
            }
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse simple function definitions`() {
        val rootNode = parser.parse("fun mul(x, y) = x * y", "<test>")
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse function definitions with 'return' statements`() {
        val rootNode = parser.parse(
            """
            fun spawnActor(x) = {
                a = create Actor(x);
                return a
            }
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse conditional execution statements`() {
        val rootNode = parser.parse(
            """
            fun max(x, y) = {
                if (x >= y) {
                    return x
                } else {
                    return y
                }
            }
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse behavior definitions with 'become' statements`() {
        val rootNode = parser.parse(
            """
            Adder (X) ["add", value] = become Adder (X + value)
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse arithmetic expressions`() {
        val rootNode = parser.parse(
            """
            display x * 2 + (2 / y * 8) - (value % x) * +(-1)
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse logical predicate expressions`() {
        val rootNode = parser.parse(
            """
            display true && (a || !b) || false
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse string concatenation expressions`() {
        val rootNode = parser.parse(
            """
            display "hello" + "world" + "!"
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }

    @Test
    fun `Can parse actor instantiation expressions`() {
        val rootNode = parser.parse(
            """
            myActor = create Actor(X + 10, "hello")
            """.trimIndent(),
            "<test>"
        )
        assertEquals(1, rootNode.toplevelStatements.size)
    }
}

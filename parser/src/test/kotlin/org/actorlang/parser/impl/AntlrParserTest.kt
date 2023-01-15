package org.actorlang.parser.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AntlrParserTest {

    @Test
    fun `Nodes line and column both start at 1`() {
        val parser = AntlrParserFactory().createParser()
        val rootNode = parser.parse("a = 42", "<test>")
        assertEquals(1, rootNode.startPosition.line)
        assertEquals(1, rootNode.startPosition.column)
    }
}

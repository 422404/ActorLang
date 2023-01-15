package org.actorlang.parser.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class AntlrParserFactoryIT {
    @Test
    fun `Creates an ANTLR parser`() {
        val parserFactory = AntlrParserFactory()
        val parser = parserFactory.createParser()
        assertTrue(parser is AntlrParser)
    }
}

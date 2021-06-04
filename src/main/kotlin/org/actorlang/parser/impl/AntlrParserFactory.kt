package org.actorlang.parser.impl

import org.actorlang.parser.Parser
import org.actorlang.parser.ParserFactory

class AntlrParserFactory : ParserFactory {
    override fun createParser(): Parser {
        return AntlrParser()
    }
}

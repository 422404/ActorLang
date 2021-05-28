package org.actorlang.antlr

import org.actorlang.parser.Position
import org.actorlang.parser.exceptions.SyntaxError
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class ActorLangAntlrErrorListener : BaseErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>,
        offendingSymbol: Any,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ) {
        val position = Position(line, charPositionInLine, e?.inputStream?.sourceName ?: "<unknown>")
        throw SyntaxError(msg, position)
    }
}

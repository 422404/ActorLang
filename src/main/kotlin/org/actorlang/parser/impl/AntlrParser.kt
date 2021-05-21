package org.actorlang.parser.impl

import org.actorlang.antlr.ActorLangBaseVisitor
import org.actorlang.antlr.ActorLangLexer
import org.actorlang.antlr.ActorLangParser
import org.actorlang.antlr.ActorLangAntlrErrorListener
import org.actorlang.ast.Node
import org.actorlang.ast.RootNode
import org.actorlang.parser.Parser
import org.actorlang.parser.Position
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token

class AntlrParser(
    private val sourceName: String
): ActorLangBaseVisitor<Node>(), Parser {
    override fun parse(text: String): Node {
        val lexer = ActorLangLexer(CharStreams.fromString(text, sourceName))
        val parser = ActorLangParser(CommonTokenStream(lexer))
        // remove the default error listener to disable error printing
        parser.removeErrorListeners()
        parser.addErrorListener(ActorLangAntlrErrorListener())
        return visit(parser.root())
    }

    private fun sourcePosition(token: Token) =
        Position(token.line, token.charPositionInLine, token.inputStream.sourceName)

    override fun visitRoot(ctx: ActorLangParser.RootContext): Node {
        return RootNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop)
        )
    }
}

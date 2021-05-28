package org.actorlang.parser.impl

import org.actorlang.antlr.ActorLangAntlrErrorListener
import org.actorlang.antlr.ActorLangBaseVisitor
import org.actorlang.antlr.ActorLangLexer
import org.actorlang.antlr.ActorLangParser
import org.actorlang.ast.AssignNode
import org.actorlang.ast.BecomeNode
import org.actorlang.ast.BehaviorNode
import org.actorlang.ast.BinaryOpNode
import org.actorlang.ast.BinaryOpType
import org.actorlang.ast.BooleanLiteralNode
import org.actorlang.ast.CreateNode
import org.actorlang.ast.DisplayNode
import org.actorlang.ast.ExpressionNode
import org.actorlang.ast.IdentifierNode
import org.actorlang.ast.IfNode
import org.actorlang.ast.IntegerLiteralNode
import org.actorlang.ast.MessagePatternItem
import org.actorlang.ast.Node
import org.actorlang.ast.RootNode
import org.actorlang.ast.SelfLiteralNode
import org.actorlang.ast.SendNode
import org.actorlang.ast.StatementNode
import org.actorlang.ast.StringLiteralNode
import org.actorlang.ast.UnaryOpNode
import org.actorlang.ast.UnaryOpType
import org.actorlang.parser.Parser
import org.actorlang.parser.Position
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

class AntlrParser(
    private val sourceName: String
) : ActorLangBaseVisitor<Node>(), Parser {

    override fun parse(text: String): RootNode {
        val lexer = ActorLangLexer(CharStreams.fromString(text, sourceName))
        val parser = ActorLangParser(CommonTokenStream(lexer))
        // remove the default error listener to disable error printing
        parser.removeErrorListeners()
        parser.addErrorListener(ActorLangAntlrErrorListener())
        return visit(parser.root()) as RootNode
    }

    private fun sourcePosition(token: Token) =
        Position(token.line, token.charPositionInLine, token.inputStream.sourceName)

    private fun createBinaryOpOrExpressionNode(
        type: BinaryOpType,
        ctx: ParserRuleContext,
        leftCtx: ParserRuleContext,
        rightCtx: ParserRuleContext?
    ) =
        when (rightCtx) {
            null -> visit(leftCtx)
            else -> BinaryOpNode(
                startPosition = sourcePosition(ctx.start),
                endPosition = sourcePosition(ctx.stop),
                left = visit(leftCtx) as ExpressionNode,
                right = visit(rightCtx) as ExpressionNode,
                type
            )
        }

    override fun visitLiteral(ctx: ActorLangParser.LiteralContext): Node {
        val startPosition = sourcePosition(ctx.start)
        val endPosition = sourcePosition(ctx.stop)
        return when {
            ctx.IntegerLiteral() != null -> IntegerLiteralNode(
                startPosition,
                endPosition,
                value = Integer.parseInt(ctx.text)
            )
            ctx.StringLiteral() != null -> StringLiteralNode(
                startPosition,
                endPosition,
                text = ctx.text.substring(1, ctx.text.length - 1)
            )
            ctx.True() != null -> BooleanLiteralNode(
                startPosition,
                endPosition,
                value = true
            )
            ctx.False() != null -> BooleanLiteralNode(
                startPosition,
                endPosition,
                value = false
            )
            ctx.Self() != null -> SelfLiteralNode(
                startPosition,
                endPosition
            )
            else -> throw IllegalStateException()
        }
    }

    override fun visitAssignStmt(ctx: ActorLangParser.AssignStmtContext): Node {
        return AssignNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            variable = visit(ctx.identifier()) as IdentifierNode,
            value = visit(ctx.expr()) as ExpressionNode
        )
    }

    override fun visitBecomeStmt(ctx: ActorLangParser.BecomeStmtContext): Node {
        return BecomeNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            behaviorName = visit(ctx.parameterizedBehavior().identifier()) as IdentifierNode,
            stateValues = ctx.parameterizedBehavior().expr().map {
                visit(it) as ExpressionNode
            }.toTypedArray()
        )
    }

    override fun visitBehavior(ctx: ActorLangParser.BehaviorContext): Node {
        return BehaviorNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            name = visit(ctx.identifier()) as IdentifierNode,
            stateVars = ctx.behaviorState().identifier().map {
                visit(it) as IdentifierNode
            }.toTypedArray(),
            messagePatternItems = ctx.behaviorMessagePattern().behaviorMessagePatternItem().map {
                visit(it) as MessagePatternItem
            }.toTypedArray(),
            statements = ctx.behaviorStmt().map {
                visit(it) as StatementNode
            }.toTypedArray()
        )
    }

    override fun visitCreateExpr(ctx: ActorLangParser.CreateExprContext): Node {
        return CreateNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            behaviorName = visit(ctx.parameterizedBehavior().identifier()) as IdentifierNode,
            stateValues = ctx.parameterizedBehavior().expr().map {
                visit(it) as ExpressionNode
            }.toTypedArray()
        )
    }

    override fun visitDisplayStmt(ctx: ActorLangParser.DisplayStmtContext): Node {
        return DisplayNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            value = visit(ctx.expr()) as ExpressionNode
        )
    }

    override fun visitIdentifier(ctx: ActorLangParser.IdentifierContext): Node {
        return IdentifierNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            name = ctx.text
        )
    }

    override fun visitIfStmt(ctx: ActorLangParser.IfStmtContext): Node {
        return IfNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            condition = visit(ctx.expr()) as ExpressionNode,
            thenStatements = ctx.thenStmts.map {
                visit(it) as StatementNode
            }.toTypedArray(),
            elseStatements = ctx.elseStmts.map {
                visit(it) as StatementNode
            }.toTypedArray()
        )
    }

    override fun visitRoot(ctx: ActorLangParser.RootContext): Node {
        return RootNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            toplevelStatements = ctx.toplevelStmt().map {
                visit(it) as StatementNode
            }.toTypedArray()
        )
    }

    override fun visitSendStmt(ctx: ActorLangParser.SendStmtContext): Node {
        return SendNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            messageItems = ctx.expr().map {
                visit(it) as ExpressionNode
            }.toTypedArray(),
            target = visit(ctx.identifier()) as IdentifierNode
        )
    }

    override fun visitOrExpr(ctx: ActorLangParser.OrExprContext): Node =
        createBinaryOpOrExpressionNode(BinaryOpType.OR, ctx, ctx.andExpr(), ctx.orExpr())

    override fun visitAndExpr(ctx: ActorLangParser.AndExprContext): Node =
        createBinaryOpOrExpressionNode(BinaryOpType.AND, ctx, ctx.eqExpr(), ctx.andExpr())

    override fun visitEqExpr(ctx: ActorLangParser.EqExprContext): Node =
        createBinaryOpOrExpressionNode(
            ctx.eqOp()?.let {
                if (it.Eq() != null)
                    BinaryOpType.EQ
                else
                    BinaryOpType.NEQ
            } ?: BinaryOpType.EQ, // Default type, the node will be stripped
            ctx, ctx.compExpr()[0],
            ctx.compExpr().let { if (it.size == 2) it[1] else null }
        )

    override fun visitCompExpr(ctx: ActorLangParser.CompExprContext): Node =
        createBinaryOpOrExpressionNode(
            ctx.compOp()?.let {
                when {
                    it.Lower() != null -> BinaryOpType.LOWER
                    it.Leq() != null -> BinaryOpType.LEQ
                    it.Greater() != null -> BinaryOpType.GREATER
                    it.Geq() != null -> BinaryOpType.GEQ
                    else -> throw IllegalStateException()
                }
            } ?: BinaryOpType.ADD, // Default type, the node will be stripped
            ctx, ctx.arithExpr()[0],
            ctx.arithExpr().let { if (it.size == 2) it[1] else null }
        )

    override fun visitArithExpr(ctx: ActorLangParser.ArithExprContext): Node =
        createBinaryOpOrExpressionNode(
            ctx.arithOp()?.let {
                if (it.Plus() != null)
                    BinaryOpType.ADD
                else
                    BinaryOpType.SUB
            } ?: BinaryOpType.ADD, // Default type, the node will be stripped
            ctx, ctx.termExpr(), ctx.arithExpr()
        )

    override fun visitTermExpr(ctx: ActorLangParser.TermExprContext): Node =
        createBinaryOpOrExpressionNode(BinaryOpType.MUL, ctx, ctx.factorExpr(), ctx.termExpr())

    override fun visitFactorExpr(ctx: ActorLangParser.FactorExprContext): Node =
        createBinaryOpOrExpressionNode(BinaryOpType.DIV, ctx, ctx.moduloExpr(), ctx.factorExpr())

    override fun visitModuloExpr(ctx: ActorLangParser.ModuloExprContext): Node =
        createBinaryOpOrExpressionNode(
            BinaryOpType.MOD, ctx, ctx.unary()[0],
            ctx.unary().let { if (it.size == 2) it[1] else null }
        )

    override fun visitUnaryPlus(ctx: ActorLangParser.UnaryPlusContext): Node {
        return UnaryOpNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            operand = visit(ctx.atom()) as ExpressionNode,
            type = UnaryOpType.PLUS
        )
    }

    override fun visitUnaryMinus(ctx: ActorLangParser.UnaryMinusContext): Node {
        return UnaryOpNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            operand = visit(ctx.atom()) as ExpressionNode,
            type = UnaryOpType.MINUS
        )
    }

    override fun visitUnaryNot(ctx: ActorLangParser.UnaryNotContext): Node {
        return UnaryOpNode(
            startPosition = sourcePosition(ctx.start),
            endPosition = sourcePosition(ctx.stop),
            operand = visit(ctx.atom()) as ExpressionNode,
            type = UnaryOpType.NOT
        )
    }

    override fun visitParenExpression(ctx: ActorLangParser.ParenExpressionContext): Node {
        return visit(ctx.expr())
    }
}

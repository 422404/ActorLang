// Generated from org/actorlang/antlr/ActorLang.g4 by ANTLR 4.9

    package org.actorlang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ActorLangParser}.
 */
public interface ActorLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void enterEqOp(ActorLangParser.EqOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void exitEqOp(ActorLangParser.EqOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(ActorLangParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(ActorLangParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#arithOp}.
	 * @param ctx the parse tree
	 */
	void enterArithOp(ActorLangParser.ArithOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#arithOp}.
	 * @param ctx the parse tree
	 */
	void exitArithOp(ActorLangParser.ArithOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ActorLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ActorLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(ActorLangParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(ActorLangParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ActorLangParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ActorLangParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(ActorLangParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(ActorLangParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(ActorLangParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(ActorLangParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(ActorLangParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(ActorLangParser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(ActorLangParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(ActorLangParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#factorExpr}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpr(ActorLangParser.FactorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#factorExpr}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpr(ActorLangParser.FactorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#moduloExpr}.
	 * @param ctx the parse tree
	 */
	void enterModuloExpr(ActorLangParser.ModuloExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#moduloExpr}.
	 * @param ctx the parse tree
	 */
	void exitModuloExpr(ActorLangParser.ModuloExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#unaryPlus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlus(ActorLangParser.UnaryPlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#unaryPlus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlus(ActorLangParser.UnaryPlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(ActorLangParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(ActorLangParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#unaryNot}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNot(ActorLangParser.UnaryNotContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#unaryNot}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNot(ActorLangParser.UnaryNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ActorLangParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ActorLangParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ActorLangParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ActorLangParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ActorLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ActorLangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ActorLangParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ActorLangParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(ActorLangParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(ActorLangParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#behavior}.
	 * @param ctx the parse tree
	 */
	void enterBehavior(ActorLangParser.BehaviorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#behavior}.
	 * @param ctx the parse tree
	 */
	void exitBehavior(ActorLangParser.BehaviorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#behaviorState}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorState(ActorLangParser.BehaviorStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#behaviorState}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorState(ActorLangParser.BehaviorStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#behaviorMessagePattern}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorMessagePattern(ActorLangParser.BehaviorMessagePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#behaviorMessagePattern}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorMessagePattern(ActorLangParser.BehaviorMessagePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#behaviorMessagePatternItem}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorMessagePatternItem(ActorLangParser.BehaviorMessagePatternItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#behaviorMessagePatternItem}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorMessagePatternItem(ActorLangParser.BehaviorMessagePatternItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#behaviorStmt}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorStmt(ActorLangParser.BehaviorStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#behaviorStmt}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorStmt(ActorLangParser.BehaviorStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#displayStmt}.
	 * @param ctx the parse tree
	 */
	void enterDisplayStmt(ActorLangParser.DisplayStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#displayStmt}.
	 * @param ctx the parse tree
	 */
	void exitDisplayStmt(ActorLangParser.DisplayStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#becomeStmt}.
	 * @param ctx the parse tree
	 */
	void enterBecomeStmt(ActorLangParser.BecomeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#becomeStmt}.
	 * @param ctx the parse tree
	 */
	void exitBecomeStmt(ActorLangParser.BecomeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#sendStmt}.
	 * @param ctx the parse tree
	 */
	void enterSendStmt(ActorLangParser.SendStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#sendStmt}.
	 * @param ctx the parse tree
	 */
	void exitSendStmt(ActorLangParser.SendStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(ActorLangParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(ActorLangParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(ActorLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(ActorLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#createExpr}.
	 * @param ctx the parse tree
	 */
	void enterCreateExpr(ActorLangParser.CreateExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#createExpr}.
	 * @param ctx the parse tree
	 */
	void exitCreateExpr(ActorLangParser.CreateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#parameterizedBehavior}.
	 * @param ctx the parse tree
	 */
	void enterParameterizedBehavior(ActorLangParser.ParameterizedBehaviorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#parameterizedBehavior}.
	 * @param ctx the parse tree
	 */
	void exitParameterizedBehavior(ActorLangParser.ParameterizedBehaviorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#toplevelStmt}.
	 * @param ctx the parse tree
	 */
	void enterToplevelStmt(ActorLangParser.ToplevelStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#toplevelStmt}.
	 * @param ctx the parse tree
	 */
	void exitToplevelStmt(ActorLangParser.ToplevelStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorLangParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ActorLangParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorLangParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ActorLangParser.RootContext ctx);
}
// Generated from org/actorlang/antlr/gen/ActorLang.g4 by ANTLR 4.9

package org.actorlang.antlr.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ActorLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ActorLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#eqOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOp(ActorLangParser.EqOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(ActorLangParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#arithOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithOp(ActorLangParser.ArithOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ActorLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(ActorLangParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ActorLangParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(ActorLangParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(ActorLangParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(ActorLangParser.ArithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#termExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermExpr(ActorLangParser.TermExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#factorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorExpr(ActorLangParser.FactorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#moduloExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuloExpr(ActorLangParser.ModuloExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#unaryPlus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlus(ActorLangParser.UnaryPlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(ActorLangParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#unaryNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryNot(ActorLangParser.UnaryNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(ActorLangParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ActorLangParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ActorLangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ActorLangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(ActorLangParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#behavior}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehavior(ActorLangParser.BehaviorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#behaviorState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorState(ActorLangParser.BehaviorStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#behaviorMessagePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorMessagePattern(ActorLangParser.BehaviorMessagePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#behaviorMessagePatternItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorMessagePatternItem(ActorLangParser.BehaviorMessagePatternItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#behaviorStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorStmt(ActorLangParser.BehaviorStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#displayStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayStmt(ActorLangParser.DisplayStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#putStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutStmt(ActorLangParser.PutStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#becomeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBecomeStmt(ActorLangParser.BecomeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#sendStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendStmt(ActorLangParser.SendStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(ActorLangParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#ifBehaviorStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBehaviorStmt(ActorLangParser.IfBehaviorStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#ifFunStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfFunStmt(ActorLangParser.IfFunStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(ActorLangParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#funDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(ActorLangParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#funStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunStmt(ActorLangParser.FunStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(ActorLangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#funCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(ActorLangParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#createExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateExpr(ActorLangParser.CreateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#parameterizedBehavior}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterizedBehavior(ActorLangParser.ParameterizedBehaviorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#toplevelStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToplevelStmt(ActorLangParser.ToplevelStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ActorLangParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(ActorLangParser.RootContext ctx);
}
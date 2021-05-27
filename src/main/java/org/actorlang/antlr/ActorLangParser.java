// Generated from org/actorlang/antlr/ActorLang.g4 by ANTLR 4.9

    package org.actorlang.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActorLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, IntegerLiteral=2, StringLiteral=3, True=4, False=5, Self=6, Create=7, 
		Become=8, Display=9, Send=10, To=11, If=12, Else=13, Identifier=14, LParen=15, 
		RParen=16, LBracket=17, RBracket=18, LCurly=19, RCurly=20, Comma=21, Semi=22, 
		Assign=23, Eq=24, Neq=25, Lower=26, Leq=27, Greater=28, Geq=29, And=30, 
		Or=31, Plus=32, Minus=33, Star=34, Slash=35, Percent=36, Not=37;
	public static final int
		RULE_eqOp = 0, RULE_compOp = 1, RULE_arithOp = 2, RULE_expr = 3, RULE_orExpr = 4, 
		RULE_andExpr = 5, RULE_eqExpr = 6, RULE_compExpr = 7, RULE_arithExpr = 8, 
		RULE_termExpr = 9, RULE_factorExpr = 10, RULE_moduloExpr = 11, RULE_unaryPlus = 12, 
		RULE_unaryMinus = 13, RULE_unaryNot = 14, RULE_unary = 15, RULE_atom = 16, 
		RULE_literal = 17, RULE_identifier = 18, RULE_parenExpression = 19, RULE_behavior = 20, 
		RULE_behaviorState = 21, RULE_behaviorMessagePattern = 22, RULE_behaviorMessagePatternItem = 23, 
		RULE_behaviorStmt = 24, RULE_displayStmt = 25, RULE_becomeStmt = 26, RULE_sendStmt = 27, 
		RULE_assignStmt = 28, RULE_ifStmt = 29, RULE_createExpr = 30, RULE_parameterizedBehavior = 31, 
		RULE_toplevelStmt = 32, RULE_root = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"eqOp", "compOp", "arithOp", "expr", "orExpr", "andExpr", "eqExpr", "compExpr", 
			"arithExpr", "termExpr", "factorExpr", "moduloExpr", "unaryPlus", "unaryMinus", 
			"unaryNot", "unary", "atom", "literal", "identifier", "parenExpression", 
			"behavior", "behaviorState", "behaviorMessagePattern", "behaviorMessagePatternItem", 
			"behaviorStmt", "displayStmt", "becomeStmt", "sendStmt", "assignStmt", 
			"ifStmt", "createExpr", "parameterizedBehavior", "toplevelStmt", "root"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'true'", "'false'", "'self'", "'create'", "'become'", 
			"'display'", "'send'", "'to'", "'if'", "'else'", null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "','", "';'", null, "'=='", null, "'<'", 
			null, "'>'", null, "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "IntegerLiteral", "StringLiteral", "True", "False", "Self", 
			"Create", "Become", "Display", "Send", "To", "If", "Else", "Identifier", 
			"LParen", "RParen", "LBracket", "RBracket", "LCurly", "RCurly", "Comma", 
			"Semi", "Assign", "Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", 
			"Or", "Plus", "Minus", "Star", "Slash", "Percent", "Not"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ActorLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ActorLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class EqOpContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(ActorLangParser.Eq, 0); }
		public TerminalNode Neq() { return getToken(ActorLangParser.Neq, 0); }
		public EqOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterEqOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitEqOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitEqOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqOpContext eqOp() throws RecognitionException {
		EqOpContext _localctx = new EqOpContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==Eq || _la==Neq) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode Lower() { return getToken(ActorLangParser.Lower, 0); }
		public TerminalNode Leq() { return getToken(ActorLangParser.Leq, 0); }
		public TerminalNode Greater() { return getToken(ActorLangParser.Greater, 0); }
		public TerminalNode Geq() { return getToken(ActorLangParser.Geq, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lower) | (1L << Leq) | (1L << Greater) | (1L << Geq))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithOpContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(ActorLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(ActorLangParser.Minus, 0); }
		public ArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterArithOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitArithOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitArithOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOpContext arithOp() throws RecognitionException {
		ArithOpContext _localctx = new ArithOpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arithOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public CreateExprContext createExpr() {
			return getRuleContext(CreateExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case StringLiteral:
			case True:
			case False:
			case Self:
			case Identifier:
			case LParen:
			case Plus:
			case Minus:
			case Not:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				orExpr();
				}
				break;
			case Create:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				createExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode Or() { return getToken(ActorLangParser.Or, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			andExpr();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Or) {
				{
				setState(79);
				match(Or);
				setState(80);
				orExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public TerminalNode And() { return getToken(ActorLangParser.And, 0); }
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			eqExpr();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(84);
				match(And);
				setState(85);
				andExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqExprContext extends ParserRuleContext {
		public List<CompExprContext> compExpr() {
			return getRuleContexts(CompExprContext.class);
		}
		public CompExprContext compExpr(int i) {
			return getRuleContext(CompExprContext.class,i);
		}
		public EqOpContext eqOp() {
			return getRuleContext(EqOpContext.class,0);
		}
		public EqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExprContext eqExpr() throws RecognitionException {
		EqExprContext _localctx = new EqExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eqExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			compExpr();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Eq || _la==Neq) {
				{
				setState(89);
				eqOp();
				setState(90);
				compExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompExprContext extends ParserRuleContext {
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompExprContext compExpr() throws RecognitionException {
		CompExprContext _localctx = new CompExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			arithExpr();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lower) | (1L << Leq) | (1L << Greater) | (1L << Geq))) != 0)) {
				{
				setState(95);
				compOp();
				setState(96);
				arithExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithExprContext extends ParserRuleContext {
		public TermExprContext termExpr() {
			return getRuleContext(TermExprContext.class,0);
		}
		public ArithOpContext arithOp() {
			return getRuleContext(ArithOpContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		ArithExprContext _localctx = new ArithExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arithExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			termExpr();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(101);
				arithOp();
				setState(102);
				arithExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermExprContext extends ParserRuleContext {
		public FactorExprContext factorExpr() {
			return getRuleContext(FactorExprContext.class,0);
		}
		public TerminalNode Star() { return getToken(ActorLangParser.Star, 0); }
		public TermExprContext termExpr() {
			return getRuleContext(TermExprContext.class,0);
		}
		public TermExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterTermExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitTermExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitTermExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermExprContext termExpr() throws RecognitionException {
		TermExprContext _localctx = new TermExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_termExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			factorExpr();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(107);
				match(Star);
				setState(108);
				termExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorExprContext extends ParserRuleContext {
		public ModuloExprContext moduloExpr() {
			return getRuleContext(ModuloExprContext.class,0);
		}
		public TerminalNode Slash() { return getToken(ActorLangParser.Slash, 0); }
		public FactorExprContext factorExpr() {
			return getRuleContext(FactorExprContext.class,0);
		}
		public FactorExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterFactorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitFactorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitFactorExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorExprContext factorExpr() throws RecognitionException {
		FactorExprContext _localctx = new FactorExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_factorExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			moduloExpr();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Slash) {
				{
				setState(112);
				match(Slash);
				setState(113);
				factorExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuloExprContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public TerminalNode Percent() { return getToken(ActorLangParser.Percent, 0); }
		public ModuloExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduloExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterModuloExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitModuloExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitModuloExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuloExprContext moduloExpr() throws RecognitionException {
		ModuloExprContext _localctx = new ModuloExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_moduloExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			unary();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Percent) {
				{
				setState(117);
				match(Percent);
				setState(118);
				unary();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryPlusContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(ActorLangParser.Plus, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryPlus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterUnaryPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitUnaryPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitUnaryPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryPlusContext unaryPlus() throws RecognitionException {
		UnaryPlusContext _localctx = new UnaryPlusContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unaryPlus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(Plus);
			setState(122);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMinusContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(ActorLangParser.Minus, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryMinus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(Minus);
			setState(125);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryNotContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(ActorLangParser.Not, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryNot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterUnaryNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitUnaryNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitUnaryNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryNotContext unaryNot() throws RecognitionException {
		UnaryNotContext _localctx = new UnaryNotContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryNot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(Not);
			setState(128);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public UnaryPlusContext unaryPlus() {
			return getRuleContext(UnaryPlusContext.class,0);
		}
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public UnaryNotContext unaryNot() {
			return getRuleContext(UnaryNotContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				unaryPlus();
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				unaryMinus();
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				unaryNot();
				}
				break;
			case IntegerLiteral:
			case StringLiteral:
			case True:
			case False:
			case Self:
			case Identifier:
			case LParen:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atom);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case StringLiteral:
			case True:
			case False:
			case Self:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				identifier();
				}
				break;
			case LParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				parenExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(ActorLangParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(ActorLangParser.StringLiteral, 0); }
		public TerminalNode True() { return getToken(ActorLangParser.True, 0); }
		public TerminalNode False() { return getToken(ActorLangParser.False, 0); }
		public TerminalNode Self() { return getToken(ActorLangParser.Self, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << True) | (1L << False) | (1L << Self))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ActorLangParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenExpressionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(ActorLangParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(ActorLangParser.RParen, 0); }
		public ParenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(LParen);
			setState(146);
			expr();
			setState(147);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BehaviorStateContext behaviorState() {
			return getRuleContext(BehaviorStateContext.class,0);
		}
		public BehaviorMessagePatternContext behaviorMessagePattern() {
			return getRuleContext(BehaviorMessagePatternContext.class,0);
		}
		public TerminalNode Assign() { return getToken(ActorLangParser.Assign, 0); }
		public List<BehaviorStmtContext> behaviorStmt() {
			return getRuleContexts(BehaviorStmtContext.class);
		}
		public BehaviorStmtContext behaviorStmt(int i) {
			return getRuleContext(BehaviorStmtContext.class,i);
		}
		public TerminalNode LCurly() { return getToken(ActorLangParser.LCurly, 0); }
		public TerminalNode RCurly() { return getToken(ActorLangParser.RCurly, 0); }
		public List<TerminalNode> Semi() { return getTokens(ActorLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(ActorLangParser.Semi, i);
		}
		public BehaviorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behavior; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBehavior(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBehavior(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBehavior(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorContext behavior() throws RecognitionException {
		BehaviorContext _localctx = new BehaviorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_behavior);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			identifier();
			setState(150);
			behaviorState();
			setState(151);
			behaviorMessagePattern();
			setState(152);
			match(Assign);
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Become:
			case Display:
			case Send:
			case If:
			case Identifier:
				{
				setState(153);
				behaviorStmt();
				}
				break;
			case LCurly:
				{
				{
				setState(154);
				match(LCurly);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Become) | (1L << Display) | (1L << Send) | (1L << If) | (1L << Identifier))) != 0)) {
					{
					setState(155);
					behaviorStmt();
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(156);
							match(Semi);
							setState(157);
							behaviorStmt();
							}
							} 
						}
						setState(162);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Semi) {
						{
						setState(163);
						match(Semi);
						}
					}

					}
				}

				setState(168);
				match(RCurly);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorStateContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(ActorLangParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(ActorLangParser.RParen, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ActorLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ActorLangParser.Comma, i);
		}
		public BehaviorStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBehaviorState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBehaviorState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBehaviorState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorStateContext behaviorState() throws RecognitionException {
		BehaviorStateContext _localctx = new BehaviorStateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_behaviorState);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(LParen);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(172);
				identifier();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(173);
					match(Comma);
					setState(174);
					identifier();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(182);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorMessagePatternContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(ActorLangParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(ActorLangParser.RBracket, 0); }
		public List<BehaviorMessagePatternItemContext> behaviorMessagePatternItem() {
			return getRuleContexts(BehaviorMessagePatternItemContext.class);
		}
		public BehaviorMessagePatternItemContext behaviorMessagePatternItem(int i) {
			return getRuleContext(BehaviorMessagePatternItemContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ActorLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ActorLangParser.Comma, i);
		}
		public BehaviorMessagePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorMessagePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBehaviorMessagePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBehaviorMessagePattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBehaviorMessagePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorMessagePatternContext behaviorMessagePattern() throws RecognitionException {
		BehaviorMessagePatternContext _localctx = new BehaviorMessagePatternContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_behaviorMessagePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LBracket);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << True) | (1L << False) | (1L << Self) | (1L << Identifier))) != 0)) {
				{
				setState(185);
				behaviorMessagePatternItem();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(186);
					match(Comma);
					setState(187);
					behaviorMessagePatternItem();
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(195);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorMessagePatternItemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public BehaviorMessagePatternItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorMessagePatternItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBehaviorMessagePatternItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBehaviorMessagePatternItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBehaviorMessagePatternItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorMessagePatternItemContext behaviorMessagePatternItem() throws RecognitionException {
		BehaviorMessagePatternItemContext _localctx = new BehaviorMessagePatternItemContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_behaviorMessagePatternItem);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				identifier();
				}
				break;
			case IntegerLiteral:
			case StringLiteral:
			case True:
			case False:
			case Self:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorStmtContext extends ParserRuleContext {
		public DisplayStmtContext displayStmt() {
			return getRuleContext(DisplayStmtContext.class,0);
		}
		public BecomeStmtContext becomeStmt() {
			return getRuleContext(BecomeStmtContext.class,0);
		}
		public SendStmtContext sendStmt() {
			return getRuleContext(SendStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public BehaviorStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBehaviorStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBehaviorStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBehaviorStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorStmtContext behaviorStmt() throws RecognitionException {
		BehaviorStmtContext _localctx = new BehaviorStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_behaviorStmt);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Display:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				displayStmt();
				}
				break;
			case Become:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				becomeStmt();
				}
				break;
			case Send:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				sendStmt();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				assignStmt();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				ifStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisplayStmtContext extends ParserRuleContext {
		public TerminalNode Display() { return getToken(ActorLangParser.Display, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DisplayStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_displayStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterDisplayStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitDisplayStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitDisplayStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayStmtContext displayStmt() throws RecognitionException {
		DisplayStmtContext _localctx = new DisplayStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_displayStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(Display);
			setState(209);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BecomeStmtContext extends ParserRuleContext {
		public TerminalNode Become() { return getToken(ActorLangParser.Become, 0); }
		public ParameterizedBehaviorContext parameterizedBehavior() {
			return getRuleContext(ParameterizedBehaviorContext.class,0);
		}
		public BecomeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_becomeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterBecomeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitBecomeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitBecomeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BecomeStmtContext becomeStmt() throws RecognitionException {
		BecomeStmtContext _localctx = new BecomeStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_becomeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(Become);
			setState(212);
			parameterizedBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SendStmtContext extends ParserRuleContext {
		public TerminalNode Send() { return getToken(ActorLangParser.Send, 0); }
		public TerminalNode LBracket() { return getToken(ActorLangParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(ActorLangParser.RBracket, 0); }
		public TerminalNode To() { return getToken(ActorLangParser.To, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ActorLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ActorLangParser.Comma, i);
		}
		public SendStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterSendStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitSendStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitSendStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendStmtContext sendStmt() throws RecognitionException {
		SendStmtContext _localctx = new SendStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_sendStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(Send);
			setState(215);
			match(LBracket);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << True) | (1L << False) | (1L << Self) | (1L << Create) | (1L << Identifier) | (1L << LParen) | (1L << Plus) | (1L << Minus) | (1L << Not))) != 0)) {
				{
				setState(216);
				expr();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(217);
					match(Comma);
					setState(218);
					expr();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(226);
			match(RBracket);
			setState(227);
			match(To);
			setState(228);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Assign() { return getToken(ActorLangParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			identifier();
			setState(231);
			match(Assign);
			setState(232);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public BehaviorStmtContext behaviorStmt;
		public List<BehaviorStmtContext> thenStmts = new ArrayList<BehaviorStmtContext>();
		public List<BehaviorStmtContext> elseStmts = new ArrayList<BehaviorStmtContext>();
		public TerminalNode If() { return getToken(ActorLangParser.If, 0); }
		public TerminalNode LParen() { return getToken(ActorLangParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(ActorLangParser.RParen, 0); }
		public List<TerminalNode> LCurly() { return getTokens(ActorLangParser.LCurly); }
		public TerminalNode LCurly(int i) {
			return getToken(ActorLangParser.LCurly, i);
		}
		public List<TerminalNode> RCurly() { return getTokens(ActorLangParser.RCurly); }
		public TerminalNode RCurly(int i) {
			return getToken(ActorLangParser.RCurly, i);
		}
		public TerminalNode Else() { return getToken(ActorLangParser.Else, 0); }
		public List<BehaviorStmtContext> behaviorStmt() {
			return getRuleContexts(BehaviorStmtContext.class);
		}
		public BehaviorStmtContext behaviorStmt(int i) {
			return getRuleContext(BehaviorStmtContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(ActorLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(ActorLangParser.Semi, i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(If);
			setState(235);
			match(LParen);
			setState(236);
			expr();
			setState(237);
			match(RParen);
			setState(238);
			match(LCurly);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Become) | (1L << Display) | (1L << Send) | (1L << If) | (1L << Identifier))) != 0)) {
				{
				setState(239);
				((IfStmtContext)_localctx).behaviorStmt = behaviorStmt();
				((IfStmtContext)_localctx).thenStmts.add(((IfStmtContext)_localctx).behaviorStmt);
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(240);
						match(Semi);
						setState(241);
						((IfStmtContext)_localctx).behaviorStmt = behaviorStmt();
						((IfStmtContext)_localctx).thenStmts.add(((IfStmtContext)_localctx).behaviorStmt);
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Semi) {
					{
					setState(247);
					match(Semi);
					}
				}

				}
			}

			setState(252);
			match(RCurly);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(253);
				match(Else);
				setState(254);
				match(LCurly);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Become) | (1L << Display) | (1L << Send) | (1L << If) | (1L << Identifier))) != 0)) {
					{
					setState(255);
					((IfStmtContext)_localctx).behaviorStmt = behaviorStmt();
					((IfStmtContext)_localctx).elseStmts.add(((IfStmtContext)_localctx).behaviorStmt);
					setState(260);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(256);
							match(Semi);
							setState(257);
							((IfStmtContext)_localctx).behaviorStmt = behaviorStmt();
							((IfStmtContext)_localctx).elseStmts.add(((IfStmtContext)_localctx).behaviorStmt);
							}
							} 
						}
						setState(262);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Semi) {
						{
						setState(263);
						match(Semi);
						}
					}

					}
				}

				setState(268);
				match(RCurly);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateExprContext extends ParserRuleContext {
		public TerminalNode Create() { return getToken(ActorLangParser.Create, 0); }
		public ParameterizedBehaviorContext parameterizedBehavior() {
			return getRuleContext(ParameterizedBehaviorContext.class,0);
		}
		public CreateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterCreateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitCreateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitCreateExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateExprContext createExpr() throws RecognitionException {
		CreateExprContext _localctx = new CreateExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_createExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(Create);
			setState(272);
			parameterizedBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterizedBehaviorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LParen() { return getToken(ActorLangParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(ActorLangParser.RParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ActorLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ActorLangParser.Comma, i);
		}
		public ParameterizedBehaviorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterizedBehavior; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterParameterizedBehavior(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitParameterizedBehavior(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitParameterizedBehavior(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterizedBehaviorContext parameterizedBehavior() throws RecognitionException {
		ParameterizedBehaviorContext _localctx = new ParameterizedBehaviorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_parameterizedBehavior);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			identifier();
			setState(275);
			match(LParen);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << StringLiteral) | (1L << True) | (1L << False) | (1L << Self) | (1L << Create) | (1L << Identifier) | (1L << LParen) | (1L << Plus) | (1L << Minus) | (1L << Not))) != 0)) {
				{
				setState(276);
				expr();
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(277);
					match(Comma);
					setState(278);
					expr();
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(286);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToplevelStmtContext extends ParserRuleContext {
		public BehaviorContext behavior() {
			return getRuleContext(BehaviorContext.class,0);
		}
		public DisplayStmtContext displayStmt() {
			return getRuleContext(DisplayStmtContext.class,0);
		}
		public SendStmtContext sendStmt() {
			return getRuleContext(SendStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ToplevelStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toplevelStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterToplevelStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitToplevelStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitToplevelStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToplevelStmtContext toplevelStmt() throws RecognitionException {
		ToplevelStmtContext _localctx = new ToplevelStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_toplevelStmt);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				behavior();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				displayStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				sendStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				assignStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ActorLangParser.EOF, 0); }
		public List<ToplevelStmtContext> toplevelStmt() {
			return getRuleContexts(ToplevelStmtContext.class);
		}
		public ToplevelStmtContext toplevelStmt(int i) {
			return getRuleContext(ToplevelStmtContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(ActorLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(ActorLangParser.Semi, i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorLangListener ) ((ActorLangListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ActorLangVisitor ) return ((ActorLangVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_root);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Display) | (1L << Send) | (1L << Identifier))) != 0)) {
				{
				setState(294);
				toplevelStmt();
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(295);
						match(Semi);
						setState(296);
						toplevelStmt();
						}
						} 
					}
					setState(301);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Semi) {
					{
					setState(302);
					match(Semi);
					}
				}

				}
			}

			setState(307);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0138\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5O\n\5\3\6\3\6\3\6"+
		"\5\6T\n\6\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3"+
		"\t\5\te\n\t\3\n\3\n\3\n\3\n\5\nk\n\n\3\13\3\13\3\13\5\13p\n\13\3\f\3\f"+
		"\3\f\5\fu\n\f\3\r\3\r\3\r\5\rz\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u0089\n\21\3\22\3\22\3\22\5\22\u008e"+
		"\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u00a1\n\26\f\26\16\26\u00a4\13\26\3\26\5\26"+
		"\u00a7\n\26\5\26\u00a9\n\26\3\26\5\26\u00ac\n\26\3\27\3\27\3\27\3\27\7"+
		"\27\u00b2\n\27\f\27\16\27\u00b5\13\27\5\27\u00b7\n\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\7\30\u00bf\n\30\f\30\16\30\u00c2\13\30\5\30\u00c4\n\30\3"+
		"\30\3\30\3\31\3\31\5\31\u00ca\n\31\3\32\3\32\3\32\3\32\3\32\5\32\u00d1"+
		"\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u00de"+
		"\n\35\f\35\16\35\u00e1\13\35\5\35\u00e3\n\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u00f5\n\37"+
		"\f\37\16\37\u00f8\13\37\3\37\5\37\u00fb\n\37\5\37\u00fd\n\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\7\37\u0105\n\37\f\37\16\37\u0108\13\37\3\37\5\37"+
		"\u010b\n\37\5\37\u010d\n\37\3\37\5\37\u0110\n\37\3 \3 \3 \3!\3!\3!\3!"+
		"\3!\7!\u011a\n!\f!\16!\u011d\13!\5!\u011f\n!\3!\3!\3\"\3\"\3\"\3\"\5\""+
		"\u0127\n\"\3#\3#\3#\7#\u012c\n#\f#\16#\u012f\13#\3#\5#\u0132\n#\5#\u0134"+
		"\n#\3#\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BD\2\6\3\2\32\33\3\2\34\37\3\2\"#\3\2\4\b\2\u0141\2F\3\2\2"+
		"\2\4H\3\2\2\2\6J\3\2\2\2\bN\3\2\2\2\nP\3\2\2\2\fU\3\2\2\2\16Z\3\2\2\2"+
		"\20`\3\2\2\2\22f\3\2\2\2\24l\3\2\2\2\26q\3\2\2\2\30v\3\2\2\2\32{\3\2\2"+
		"\2\34~\3\2\2\2\36\u0081\3\2\2\2 \u0088\3\2\2\2\"\u008d\3\2\2\2$\u008f"+
		"\3\2\2\2&\u0091\3\2\2\2(\u0093\3\2\2\2*\u0097\3\2\2\2,\u00ad\3\2\2\2."+
		"\u00ba\3\2\2\2\60\u00c9\3\2\2\2\62\u00d0\3\2\2\2\64\u00d2\3\2\2\2\66\u00d5"+
		"\3\2\2\28\u00d8\3\2\2\2:\u00e8\3\2\2\2<\u00ec\3\2\2\2>\u0111\3\2\2\2@"+
		"\u0114\3\2\2\2B\u0126\3\2\2\2D\u0133\3\2\2\2FG\t\2\2\2G\3\3\2\2\2HI\t"+
		"\3\2\2I\5\3\2\2\2JK\t\4\2\2K\7\3\2\2\2LO\5\n\6\2MO\5> \2NL\3\2\2\2NM\3"+
		"\2\2\2O\t\3\2\2\2PS\5\f\7\2QR\7!\2\2RT\5\n\6\2SQ\3\2\2\2ST\3\2\2\2T\13"+
		"\3\2\2\2UX\5\16\b\2VW\7 \2\2WY\5\f\7\2XV\3\2\2\2XY\3\2\2\2Y\r\3\2\2\2"+
		"Z^\5\20\t\2[\\\5\2\2\2\\]\5\20\t\2]_\3\2\2\2^[\3\2\2\2^_\3\2\2\2_\17\3"+
		"\2\2\2`d\5\22\n\2ab\5\4\3\2bc\5\22\n\2ce\3\2\2\2da\3\2\2\2de\3\2\2\2e"+
		"\21\3\2\2\2fj\5\24\13\2gh\5\6\4\2hi\5\22\n\2ik\3\2\2\2jg\3\2\2\2jk\3\2"+
		"\2\2k\23\3\2\2\2lo\5\26\f\2mn\7$\2\2np\5\24\13\2om\3\2\2\2op\3\2\2\2p"+
		"\25\3\2\2\2qt\5\30\r\2rs\7%\2\2su\5\26\f\2tr\3\2\2\2tu\3\2\2\2u\27\3\2"+
		"\2\2vy\5 \21\2wx\7&\2\2xz\5 \21\2yw\3\2\2\2yz\3\2\2\2z\31\3\2\2\2{|\7"+
		"\"\2\2|}\5\"\22\2}\33\3\2\2\2~\177\7#\2\2\177\u0080\5\"\22\2\u0080\35"+
		"\3\2\2\2\u0081\u0082\7\'\2\2\u0082\u0083\5\"\22\2\u0083\37\3\2\2\2\u0084"+
		"\u0089\5\32\16\2\u0085\u0089\5\34\17\2\u0086\u0089\5\36\20\2\u0087\u0089"+
		"\5\"\22\2\u0088\u0084\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2"+
		"\u0088\u0087\3\2\2\2\u0089!\3\2\2\2\u008a\u008e\5$\23\2\u008b\u008e\5"+
		"&\24\2\u008c\u008e\5(\25\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e#\3\2\2\2\u008f\u0090\t\5\2\2\u0090%\3\2\2\2\u0091"+
		"\u0092\7\20\2\2\u0092\'\3\2\2\2\u0093\u0094\7\21\2\2\u0094\u0095\5\b\5"+
		"\2\u0095\u0096\7\22\2\2\u0096)\3\2\2\2\u0097\u0098\5&\24\2\u0098\u0099"+
		"\5,\27\2\u0099\u009a\5.\30\2\u009a\u00ab\7\31\2\2\u009b\u00ac\5\62\32"+
		"\2\u009c\u00a8\7\25\2\2\u009d\u00a2\5\62\32\2\u009e\u009f\7\30\2\2\u009f"+
		"\u00a1\5\62\32\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a7\7\30\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3"+
		"\2\2\2\u00a8\u009d\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\7\26\2\2\u00ab\u009b\3\2\2\2\u00ab\u009c\3\2\2\2\u00ac+\3\2\2\2"+
		"\u00ad\u00b6\7\21\2\2\u00ae\u00b3\5&\24\2\u00af\u00b0\7\27\2\2\u00b0\u00b2"+
		"\5&\24\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00ae\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\22\2\2\u00b9"+
		"-\3\2\2\2\u00ba\u00c3\7\23\2\2\u00bb\u00c0\5\60\31\2\u00bc\u00bd\7\27"+
		"\2\2\u00bd\u00bf\5\60\31\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\7\24\2\2\u00c6/\3\2\2\2\u00c7\u00ca\5&\24\2\u00c8\u00ca\5$\23\2"+
		"\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\61\3\2\2\2\u00cb\u00d1"+
		"\5\64\33\2\u00cc\u00d1\5\66\34\2\u00cd\u00d1\58\35\2\u00ce\u00d1\5:\36"+
		"\2\u00cf\u00d1\5<\37\2\u00d0\u00cb\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00cd"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\63\3\2\2\2\u00d2"+
		"\u00d3\7\13\2\2\u00d3\u00d4\5\b\5\2\u00d4\65\3\2\2\2\u00d5\u00d6\7\n\2"+
		"\2\u00d6\u00d7\5@!\2\u00d7\67\3\2\2\2\u00d8\u00d9\7\f\2\2\u00d9\u00e2"+
		"\7\23\2\2\u00da\u00df\5\b\5\2\u00db\u00dc\7\27\2\2\u00dc\u00de\5\b\5\2"+
		"\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\24\2\2\u00e5\u00e6\7"+
		"\r\2\2\u00e6\u00e7\5&\24\2\u00e79\3\2\2\2\u00e8\u00e9\5&\24\2\u00e9\u00ea"+
		"\7\31\2\2\u00ea\u00eb\5\b\5\2\u00eb;\3\2\2\2\u00ec\u00ed\7\16\2\2\u00ed"+
		"\u00ee\7\21\2\2\u00ee\u00ef\5\b\5\2\u00ef\u00f0\7\22\2\2\u00f0\u00fc\7"+
		"\25\2\2\u00f1\u00f6\5\62\32\2\u00f2\u00f3\7\30\2\2\u00f3\u00f5\5\62\32"+
		"\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb\7\30\2\2"+
		"\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00f1"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u010f\7\26\2\2"+
		"\u00ff\u0100\7\17\2\2\u0100\u010c\7\25\2\2\u0101\u0106\5\62\32\2\u0102"+
		"\u0103\7\30\2\2\u0103\u0105\5\62\32\2\u0104\u0102\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010b\7\30\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3"+
		"\2\2\2\u010b\u010d\3\2\2\2\u010c\u0101\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\7\26\2\2\u010f\u00ff\3\2\2\2\u010f\u0110\3"+
		"\2\2\2\u0110=\3\2\2\2\u0111\u0112\7\t\2\2\u0112\u0113\5@!\2\u0113?\3\2"+
		"\2\2\u0114\u0115\5&\24\2\u0115\u011e\7\21\2\2\u0116\u011b\5\b\5\2\u0117"+
		"\u0118\7\27\2\2\u0118\u011a\5\b\5\2\u0119\u0117\3\2\2\2\u011a\u011d\3"+
		"\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u0116\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0121\7\22\2\2\u0121A\3\2\2\2\u0122\u0127\5*\26\2\u0123\u0127"+
		"\5\64\33\2\u0124\u0127\58\35\2\u0125\u0127\5:\36\2\u0126\u0122\3\2\2\2"+
		"\u0126\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127C\3"+
		"\2\2\2\u0128\u012d\5B\"\2\u0129\u012a\7\30\2\2\u012a\u012c\5B\"\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\7\30\2\2\u0131"+
		"\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0128\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\7\2\2\3\u0136"+
		"E\3\2\2\2&NSX^djoty\u0088\u008d\u00a2\u00a6\u00a8\u00ab\u00b3\u00b6\u00c0"+
		"\u00c3\u00c9\u00d0\u00df\u00e2\u00f6\u00fa\u00fc\u0106\u010a\u010c\u010f"+
		"\u011b\u011e\u0126\u012d\u0131\u0133";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
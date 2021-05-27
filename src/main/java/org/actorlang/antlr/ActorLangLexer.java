// Generated from org/actorlang/antlr/ActorLang.g4 by ANTLR 4.9

    package org.actorlang.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActorLangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "Digit", "IntegerLiteral", "StringLiteral", "True", "False", "Self", 
			"Create", "Become", "Display", "Send", "To", "If", "Else", "Identifier", 
			"LParen", "RParen", "LBracket", "RBracket", "LCurly", "RCurly", "Comma", 
			"Semi", "Assign", "Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", 
			"Or", "Plus", "Minus", "Star", "Slash", "Percent", "Not"
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


	public ActorLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ActorLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\6\2Q\n\2\r\2\16\2R\3\2"+
		"\3\2\3\3\3\3\3\4\6\4Z\n\4\r\4\16\4[\3\5\3\5\3\5\3\5\7\5b\n\5\f\5\16\5"+
		"e\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u00a1\n\20\f\20"+
		"\16\20\u00a4\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\5"+
		"\33\u00be\n\33\3\34\3\34\3\35\3\35\3\35\5\35\u00c5\n\35\3\36\3\36\3\37"+
		"\3\37\3\37\5\37\u00cc\n\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\2\2(\3\3\5\2\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27"+
		"\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32"+
		"\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'\3\2\t\5\2\13\f\17\17\"\"\3"+
		"\2\62;\3\2$$\4\2C\\c|\6\2\62;C\\aac|\4\2??\u2192\u2192\4\2##\u00ae\u00ae"+
		"\2\u00e5\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3P\3\2\2\2\5V\3\2\2\2\7Y\3\2\2\2\t]\3"+
		"\2\2\2\13h\3\2\2\2\rm\3\2\2\2\17s\3\2\2\2\21x\3\2\2\2\23\177\3\2\2\2\25"+
		"\u0086\3\2\2\2\27\u008e\3\2\2\2\31\u0093\3\2\2\2\33\u0096\3\2\2\2\35\u0099"+
		"\3\2\2\2\37\u009e\3\2\2\2!\u00a5\3\2\2\2#\u00a7\3\2\2\2%\u00a9\3\2\2\2"+
		"\'\u00ab\3\2\2\2)\u00ad\3\2\2\2+\u00af\3\2\2\2-\u00b1\3\2\2\2/\u00b3\3"+
		"\2\2\2\61\u00b5\3\2\2\2\63\u00b7\3\2\2\2\65\u00bd\3\2\2\2\67\u00bf\3\2"+
		"\2\29\u00c4\3\2\2\2;\u00c6\3\2\2\2=\u00cb\3\2\2\2?\u00cd\3\2\2\2A\u00d0"+
		"\3\2\2\2C\u00d3\3\2\2\2E\u00d5\3\2\2\2G\u00d7\3\2\2\2I\u00d9\3\2\2\2K"+
		"\u00db\3\2\2\2M\u00dd\3\2\2\2OQ\t\2\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2ST\3\2\2\2TU\b\2\2\2U\4\3\2\2\2VW\t\3\2\2W\6\3\2\2\2XZ\5\5\3"+
		"\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\b\3\2\2\2]c\7$\2\2^_\7^"+
		"\2\2_b\13\2\2\2`b\n\4\2\2a^\3\2\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3"+
		"\2\2\2df\3\2\2\2ec\3\2\2\2fg\7$\2\2g\n\3\2\2\2hi\7v\2\2ij\7t\2\2jk\7w"+
		"\2\2kl\7g\2\2l\f\3\2\2\2mn\7h\2\2no\7c\2\2op\7n\2\2pq\7u\2\2qr\7g\2\2"+
		"r\16\3\2\2\2st\7u\2\2tu\7g\2\2uv\7n\2\2vw\7h\2\2w\20\3\2\2\2xy\7e\2\2"+
		"yz\7t\2\2z{\7g\2\2{|\7c\2\2|}\7v\2\2}~\7g\2\2~\22\3\2\2\2\177\u0080\7"+
		"d\2\2\u0080\u0081\7g\2\2\u0081\u0082\7e\2\2\u0082\u0083\7q\2\2\u0083\u0084"+
		"\7o\2\2\u0084\u0085\7g\2\2\u0085\24\3\2\2\2\u0086\u0087\7f\2\2\u0087\u0088"+
		"\7k\2\2\u0088\u0089\7u\2\2\u0089\u008a\7r\2\2\u008a\u008b\7n\2\2\u008b"+
		"\u008c\7c\2\2\u008c\u008d\7{\2\2\u008d\26\3\2\2\2\u008e\u008f\7u\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091\u0092\7f\2\2\u0092\30\3\2\2\2\u0093"+
		"\u0094\7v\2\2\u0094\u0095\7q\2\2\u0095\32\3\2\2\2\u0096\u0097\7k\2\2\u0097"+
		"\u0098\7h\2\2\u0098\34\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d\36\3\2\2\2\u009e\u00a2\t\5\2\2"+
		"\u009f\u00a1\t\6\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3 \3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a6\7*\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7+\2\2\u00a8$\3\2\2\2\u00a9"+
		"\u00aa\7]\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7_\2\2\u00ac(\3\2\2\2\u00ad\u00ae"+
		"\7}\2\2\u00ae*\3\2\2\2\u00af\u00b0\7\177\2\2\u00b0,\3\2\2\2\u00b1\u00b2"+
		"\7.\2\2\u00b2.\3\2\2\2\u00b3\u00b4\7=\2\2\u00b4\60\3\2\2\2\u00b5\u00b6"+
		"\t\7\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8\u00b9\7?\2\2\u00b9"+
		"\64\3\2\2\2\u00ba\u00bb\7#\2\2\u00bb\u00be\7?\2\2\u00bc\u00be\7\u2262"+
		"\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\66\3\2\2\2\u00bf\u00c0"+
		"\7>\2\2\u00c08\3\2\2\2\u00c1\u00c2\7>\2\2\u00c2\u00c5\7?\2\2\u00c3\u00c5"+
		"\7\u2266\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5:\3\2\2\2\u00c6"+
		"\u00c7\7@\2\2\u00c7<\3\2\2\2\u00c8\u00c9\7@\2\2\u00c9\u00cc\7?\2\2\u00ca"+
		"\u00cc\7\u2267\2\2\u00cb\u00c8\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc>\3\2"+
		"\2\2\u00cd\u00ce\7(\2\2\u00ce\u00cf\7(\2\2\u00cf@\3\2\2\2\u00d0\u00d1"+
		"\7~\2\2\u00d1\u00d2\7~\2\2\u00d2B\3\2\2\2\u00d3\u00d4\7-\2\2\u00d4D\3"+
		"\2\2\2\u00d5\u00d6\7/\2\2\u00d6F\3\2\2\2\u00d7\u00d8\7,\2\2\u00d8H\3\2"+
		"\2\2\u00d9\u00da\7\61\2\2\u00daJ\3\2\2\2\u00db\u00dc\7\'\2\2\u00dcL\3"+
		"\2\2\2\u00dd\u00de\t\b\2\2\u00deN\3\2\2\2\13\2R[ac\u00a2\u00bd\u00c4\u00cb"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
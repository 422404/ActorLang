// Generated from org/actorlang/antlr/gen/ActorLang.g4 by ANTLR 4.9

    package org.actorlang.antlr.gen;

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
		T__0=1, WS=2, IntegerLiteral=3, StringLiteral=4, True=5, False=6, Self=7, 
		Create=8, Become=9, Display=10, Send=11, To=12, If=13, Else=14, For=15, 
		In=16, Put=17, Identifier=18, LParen=19, RParen=20, LBracket=21, RBracket=22, 
		LCurly=23, RCurly=24, Comma=25, Semi=26, Assign=27, Eq=28, Neq=29, Lower=30, 
		Leq=31, Greater=32, Geq=33, And=34, Or=35, Plus=36, Minus=37, Star=38, 
		Slash=39, Percent=40, Not=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "WS", "Digit", "IntegerLiteral", "StringLiteral", "True", "False", 
			"Self", "Create", "Become", "Display", "Send", "To", "If", "Else", "For", 
			"In", "Put", "Identifier", "LParen", "RParen", "LBracket", "RBracket", 
			"LCurly", "RCurly", "Comma", "Semi", "Assign", "Eq", "Neq", "Lower", 
			"Leq", "Greater", "Geq", "And", "Or", "Plus", "Minus", "Star", "Slash", 
			"Percent", "Not"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'..'", null, null, null, "'true'", "'false'", "'self'", "'create'", 
			"'become'", "'display'", "'send'", "'to'", "'if'", "'else'", "'for'", 
			"'in'", "'put'", null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", 
			"';'", null, "'=='", null, "'<'", null, "'>'", null, "'&&'", "'||'", 
			"'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "IntegerLiteral", "StringLiteral", "True", "False", 
			"Self", "Create", "Become", "Display", "Send", "To", "If", "Else", "For", 
			"In", "Put", "Identifier", "LParen", "RParen", "LBracket", "RBracket", 
			"LCurly", "RCurly", "Comma", "Semi", "Assign", "Eq", "Neq", "Lower", 
			"Leq", "Greater", "Geq", "And", "Or", "Plus", "Minus", "Star", "Slash", 
			"Percent", "Not"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u00f5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\3\6\3\\\n\3\r\3\16\3]\3\3\3\3\3\4\3\4\3\5\6\5e\n\5\r\5\16"+
		"\5f\3\6\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\7\24\u00b7\n\24\f\24\16\24\u00ba\13\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\5\37\u00d4\n\37\3 \3 \3!\3!\3!\5!\u00db\n!\3\""+
		"\3\"\3#\3#\3#\5#\u00e2\n#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\2\2,\3\3\5\4\7\2\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31"+
		"\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33"+
		"\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+\3\2\t\5\2\13\f\17\17\"\""+
		"\3\2\62;\3\2$$\5\2C\\aac|\6\2\62;C\\aac|\4\2??\u2192\u2192\4\2##\u00ae"+
		"\u00ae\2\u00fb\2\3\3\2\2\2\2\5\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\3W\3\2\2\2\5[\3\2\2\2\7a\3\2\2\2\td\3\2\2\2\13h\3\2\2\2"+
		"\rs\3\2\2\2\17x\3\2\2\2\21~\3\2\2\2\23\u0083\3\2\2\2\25\u008a\3\2\2\2"+
		"\27\u0091\3\2\2\2\31\u0099\3\2\2\2\33\u009e\3\2\2\2\35\u00a1\3\2\2\2\37"+
		"\u00a4\3\2\2\2!\u00a9\3\2\2\2#\u00ad\3\2\2\2%\u00b0\3\2\2\2\'\u00b4\3"+
		"\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3\2\2\2/\u00c1\3\2\2\2\61"+
		"\u00c3\3\2\2\2\63\u00c5\3\2\2\2\65\u00c7\3\2\2\2\67\u00c9\3\2\2\29\u00cb"+
		"\3\2\2\2;\u00cd\3\2\2\2=\u00d3\3\2\2\2?\u00d5\3\2\2\2A\u00da\3\2\2\2C"+
		"\u00dc\3\2\2\2E\u00e1\3\2\2\2G\u00e3\3\2\2\2I\u00e6\3\2\2\2K\u00e9\3\2"+
		"\2\2M\u00eb\3\2\2\2O\u00ed\3\2\2\2Q\u00ef\3\2\2\2S\u00f1\3\2\2\2U\u00f3"+
		"\3\2\2\2WX\7\60\2\2XY\7\60\2\2Y\4\3\2\2\2Z\\\t\2\2\2[Z\3\2\2\2\\]\3\2"+
		"\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\3\2\2`\6\3\2\2\2ab\t\3\2\2b\b\3"+
		"\2\2\2ce\5\7\4\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\n\3\2\2\2hn"+
		"\7$\2\2ij\7^\2\2jm\13\2\2\2km\n\4\2\2li\3\2\2\2lk\3\2\2\2mp\3\2\2\2nl"+
		"\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7$\2\2r\f\3\2\2\2st\7v\2\2tu"+
		"\7t\2\2uv\7w\2\2vw\7g\2\2w\16\3\2\2\2xy\7h\2\2yz\7c\2\2z{\7n\2\2{|\7u"+
		"\2\2|}\7g\2\2}\20\3\2\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080\u0081\7n"+
		"\2\2\u0081\u0082\7h\2\2\u0082\22\3\2\2\2\u0083\u0084\7e\2\2\u0084\u0085"+
		"\7t\2\2\u0085\u0086\7g\2\2\u0086\u0087\7c\2\2\u0087\u0088\7v\2\2\u0088"+
		"\u0089\7g\2\2\u0089\24\3\2\2\2\u008a\u008b\7d\2\2\u008b\u008c\7g\2\2\u008c"+
		"\u008d\7e\2\2\u008d\u008e\7q\2\2\u008e\u008f\7o\2\2\u008f\u0090\7g\2\2"+
		"\u0090\26\3\2\2\2\u0091\u0092\7f\2\2\u0092\u0093\7k\2\2\u0093\u0094\7"+
		"u\2\2\u0094\u0095\7r\2\2\u0095\u0096\7n\2\2\u0096\u0097\7c\2\2\u0097\u0098"+
		"\7{\2\2\u0098\30\3\2\2\2\u0099\u009a\7u\2\2\u009a\u009b\7g\2\2\u009b\u009c"+
		"\7p\2\2\u009c\u009d\7f\2\2\u009d\32\3\2\2\2\u009e\u009f\7v\2\2\u009f\u00a0"+
		"\7q\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7h\2\2\u00a3\36"+
		"\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8 \3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7q\2\2\u00ab"+
		"\u00ac\7t\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7p\2\2\u00af"+
		"$\3\2\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7v\2\2\u00b3"+
		"&\3\2\2\2\u00b4\u00b8\t\5\2\2\u00b5\u00b7\t\6\2\2\u00b6\u00b5\3\2\2\2"+
		"\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9(\3"+
		"\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7*\2\2\u00bc*\3\2\2\2\u00bd\u00be"+
		"\7+\2\2\u00be,\3\2\2\2\u00bf\u00c0\7]\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7"+
		"_\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7}\2\2\u00c4\62\3\2\2\2\u00c5\u00c6"+
		"\7\177\2\2\u00c6\64\3\2\2\2\u00c7\u00c8\7.\2\2\u00c8\66\3\2\2\2\u00c9"+
		"\u00ca\7=\2\2\u00ca8\3\2\2\2\u00cb\u00cc\t\7\2\2\u00cc:\3\2\2\2\u00cd"+
		"\u00ce\7?\2\2\u00ce\u00cf\7?\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7#\2\2\u00d1"+
		"\u00d4\7?\2\2\u00d2\u00d4\7\u2262\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d4>\3\2\2\2\u00d5\u00d6\7>\2\2\u00d6@\3\2\2\2\u00d7\u00d8"+
		"\7>\2\2\u00d8\u00db\7?\2\2\u00d9\u00db\7\u2266\2\2\u00da\u00d7\3\2\2\2"+
		"\u00da\u00d9\3\2\2\2\u00dbB\3\2\2\2\u00dc\u00dd\7@\2\2\u00ddD\3\2\2\2"+
		"\u00de\u00df\7@\2\2\u00df\u00e2\7?\2\2\u00e0\u00e2\7\u2267\2\2\u00e1\u00de"+
		"\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2F\3\2\2\2\u00e3\u00e4\7(\2\2\u00e4\u00e5"+
		"\7(\2\2\u00e5H\3\2\2\2\u00e6\u00e7\7~\2\2\u00e7\u00e8\7~\2\2\u00e8J\3"+
		"\2\2\2\u00e9\u00ea\7-\2\2\u00eaL\3\2\2\2\u00eb\u00ec\7/\2\2\u00ecN\3\2"+
		"\2\2\u00ed\u00ee\7,\2\2\u00eeP\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0R\3\2"+
		"\2\2\u00f1\u00f2\7\'\2\2\u00f2T\3\2\2\2\u00f3\u00f4\t\b\2\2\u00f4V\3\2"+
		"\2\2\13\2]fln\u00b8\u00d3\u00da\u00e1\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
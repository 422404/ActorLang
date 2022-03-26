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
		T__0=1, WS=2, COMMENT=3, IntegerLiteral=4, StringLiteral=5, True=6, False=7, 
		Self=8, Create=9, Become=10, Display=11, Send=12, To=13, If=14, Else=15, 
		For=16, In=17, Put=18, Fun=19, Return=20, Identifier=21, LParen=22, RParen=23, 
		LBracket=24, RBracket=25, LCurly=26, RCurly=27, Comma=28, Semi=29, Assign=30, 
		Eq=31, Neq=32, Lower=33, Leq=34, Greater=35, Geq=36, And=37, Or=38, Plus=39, 
		Minus=40, Star=41, Slash=42, Percent=43, Not=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "WS", "COMMENT", "Digit", "IntegerLiteral", "StringLiteral", 
			"True", "False", "Self", "Create", "Become", "Display", "Send", "To", 
			"If", "Else", "For", "In", "Put", "Fun", "Return", "Identifier", "LParen", 
			"RParen", "LBracket", "RBracket", "LCurly", "RCurly", "Comma", "Semi", 
			"Assign", "Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", "Or", 
			"Plus", "Minus", "Star", "Slash", "Percent", "Not"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'..'", null, null, null, null, "'true'", "'false'", "'self'", 
			"'create'", "'become'", "'display'", "'send'", "'to'", "'if'", "'else'", 
			"'for'", "'in'", "'put'", "'fun'", "'return'", null, "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "','", "';'", null, "'=='", null, "'<'", null, "'>'", 
			null, "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "COMMENT", "IntegerLiteral", "StringLiteral", "True", 
			"False", "Self", "Create", "Become", "Display", "Send", "To", "If", "Else", 
			"For", "In", "Put", "Fun", "Return", "Identifier", "LParen", "RParen", 
			"LBracket", "RBracket", "LCurly", "RCurly", "Comma", "Semi", "Assign", 
			"Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", "Or", "Plus", "Minus", 
			"Star", "Slash", "Percent", "Not"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0114\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\3\6\3b\n\3\r\3\16\3c\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\7\4l\n\4\f\4\16\4o\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6\6y\n"+
		"\6\r\6\16\6z\3\7\3\7\3\7\3\7\7\7\u0081\n\7\f\7\16\7\u0084\13\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\7\27\u00d6\n\27\f\27\16\27\u00d9\13\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3!\3\"\3\"\3\"\5\"\u00f3\n\"\3#\3#\3$\3$\3$\5$\u00fa\n$\3%\3%\3&\3"+
		"&\3&\5&\u0101\n&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3"+
		".\3.\3m\2/\3\3\5\4\7\5\t\2\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33"+
		"\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67"+
		"\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.\3\2\t\5\2\13\f\17\17\""+
		"\"\3\2\62;\3\2$$\5\2C\\aac|\6\2\62;C\\aac|\4\2??\u2192\u2192\4\2##\u00ae"+
		"\u00ae\2\u011b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5a\3\2\2\2\7"+
		"g\3\2\2\2\tu\3\2\2\2\13x\3\2\2\2\r|\3\2\2\2\17\u0087\3\2\2\2\21\u008c"+
		"\3\2\2\2\23\u0092\3\2\2\2\25\u0097\3\2\2\2\27\u009e\3\2\2\2\31\u00a5\3"+
		"\2\2\2\33\u00ad\3\2\2\2\35\u00b2\3\2\2\2\37\u00b5\3\2\2\2!\u00b8\3\2\2"+
		"\2#\u00bd\3\2\2\2%\u00c1\3\2\2\2\'\u00c4\3\2\2\2)\u00c8\3\2\2\2+\u00cc"+
		"\3\2\2\2-\u00d3\3\2\2\2/\u00da\3\2\2\2\61\u00dc\3\2\2\2\63\u00de\3\2\2"+
		"\2\65\u00e0\3\2\2\2\67\u00e2\3\2\2\29\u00e4\3\2\2\2;\u00e6\3\2\2\2=\u00e8"+
		"\3\2\2\2?\u00ea\3\2\2\2A\u00ec\3\2\2\2C\u00f2\3\2\2\2E\u00f4\3\2\2\2G"+
		"\u00f9\3\2\2\2I\u00fb\3\2\2\2K\u0100\3\2\2\2M\u0102\3\2\2\2O\u0105\3\2"+
		"\2\2Q\u0108\3\2\2\2S\u010a\3\2\2\2U\u010c\3\2\2\2W\u010e\3\2\2\2Y\u0110"+
		"\3\2\2\2[\u0112\3\2\2\2]^\7\60\2\2^_\7\60\2\2_\4\3\2\2\2`b\t\2\2\2a`\3"+
		"\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\b\3\2\2f\6\3\2\2\2gh"+
		"\7\61\2\2hi\7,\2\2im\3\2\2\2jl\13\2\2\2kj\3\2\2\2lo\3\2\2\2mn\3\2\2\2"+
		"mk\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7,\2\2qr\7\61\2\2rs\3\2\2\2st\b\4\2\2"+
		"t\b\3\2\2\2uv\t\3\2\2v\n\3\2\2\2wy\5\t\5\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2"+
		"\2z{\3\2\2\2{\f\3\2\2\2|\u0082\7$\2\2}~\7^\2\2~\u0081\13\2\2\2\177\u0081"+
		"\n\4\2\2\u0080}\3\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7$\2\2\u0086\16\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089"+
		"\u008a\7w\2\2\u008a\u008b\7g\2\2\u008b\20\3\2\2\2\u008c\u008d\7h\2\2\u008d"+
		"\u008e\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090\7u\2\2\u0090\u0091\7g\2\2"+
		"\u0091\22\3\2\2\2\u0092\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094\u0095\7"+
		"n\2\2\u0095\u0096\7h\2\2\u0096\24\3\2\2\2\u0097\u0098\7e\2\2\u0098\u0099"+
		"\7t\2\2\u0099\u009a\7g\2\2\u009a\u009b\7c\2\2\u009b\u009c\7v\2\2\u009c"+
		"\u009d\7g\2\2\u009d\26\3\2\2\2\u009e\u009f\7d\2\2\u009f\u00a0\7g\2\2\u00a0"+
		"\u00a1\7e\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7o\2\2\u00a3\u00a4\7g\2\2"+
		"\u00a4\30\3\2\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7"+
		"u\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac"+
		"\7{\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af\u00b0"+
		"\7p\2\2\u00b0\u00b1\7f\2\2\u00b1\34\3\2\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4"+
		"\7q\2\2\u00b4\36\3\2\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7h\2\2\u00b7 "+
		"\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\"\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7q\2\2\u00bf"+
		"\u00c0\7t\2\2\u00c0$\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3"+
		"&\3\2\2\2\u00c4\u00c5\7r\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7v\2\2\u00c7"+
		"(\3\2\2\2\u00c8\u00c9\7h\2\2\u00c9\u00ca\7w\2\2\u00ca\u00cb\7p\2\2\u00cb"+
		"*\3\2\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7v\2\2\u00cf"+
		"\u00d0\7w\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7p\2\2\u00d2,\3\2\2\2\u00d3"+
		"\u00d7\t\5\2\2\u00d4\u00d6\t\6\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8.\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00db\7*\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7+\2\2\u00dd"+
		"\62\3\2\2\2\u00de\u00df\7]\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7_\2\2\u00e1"+
		"\66\3\2\2\2\u00e2\u00e3\7}\2\2\u00e38\3\2\2\2\u00e4\u00e5\7\177\2\2\u00e5"+
		":\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7<\3\2\2\2\u00e8\u00e9\7=\2\2\u00e9>"+
		"\3\2\2\2\u00ea\u00eb\t\7\2\2\u00eb@\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed\u00ee"+
		"\7?\2\2\u00eeB\3\2\2\2\u00ef\u00f0\7#\2\2\u00f0\u00f3\7?\2\2\u00f1\u00f3"+
		"\7\u2262\2\2\u00f2\u00ef\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3D\3\2\2\2\u00f4"+
		"\u00f5\7>\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7\u00fa\7?\2\2\u00f8"+
		"\u00fa\7\u2266\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f8\3\2\2\2\u00faH\3\2"+
		"\2\2\u00fb\u00fc\7@\2\2\u00fcJ\3\2\2\2\u00fd\u00fe\7@\2\2\u00fe\u0101"+
		"\7?\2\2\u00ff\u0101\7\u2267\2\2\u0100\u00fd\3\2\2\2\u0100\u00ff\3\2\2"+
		"\2\u0101L\3\2\2\2\u0102\u0103\7(\2\2\u0103\u0104\7(\2\2\u0104N\3\2\2\2"+
		"\u0105\u0106\7~\2\2\u0106\u0107\7~\2\2\u0107P\3\2\2\2\u0108\u0109\7-\2"+
		"\2\u0109R\3\2\2\2\u010a\u010b\7/\2\2\u010bT\3\2\2\2\u010c\u010d\7,\2\2"+
		"\u010dV\3\2\2\2\u010e\u010f\7\61\2\2\u010fX\3\2\2\2\u0110\u0111\7\'\2"+
		"\2\u0111Z\3\2\2\2\u0112\u0113\t\b\2\2\u0113\\\3\2\2\2\f\2cmz\u0080\u0082"+
		"\u00d7\u00f2\u00f9\u0100\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
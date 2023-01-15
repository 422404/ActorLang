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
		For=16, In=17, Put=18, Fun=19, Return=20, Call=21, Identifier=22, LParen=23, 
		RParen=24, LBracket=25, RBracket=26, LCurly=27, RCurly=28, Comma=29, Semi=30, 
		Assign=31, Eq=32, Neq=33, Lower=34, Leq=35, Greater=36, Geq=37, And=38, 
		Or=39, Plus=40, Minus=41, Star=42, Slash=43, Percent=44, Not=45;
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
			"If", "Else", "For", "In", "Put", "Fun", "Return", "Call", "Identifier", 
			"LParen", "RParen", "LBracket", "RBracket", "LCurly", "RCurly", "Comma", 
			"Semi", "Assign", "Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", 
			"Or", "Plus", "Minus", "Star", "Slash", "Percent", "Not"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'..'", null, null, null, null, "'true'", "'false'", "'self'", 
			"'create'", "'become'", "'display'", "'send'", "'to'", "'if'", "'else'", 
			"'for'", "'in'", "'put'", "'fun'", "'return'", "'call'", null, "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "','", "';'", null, "'=='", null, 
			"'<'", null, "'>'", null, "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", 
			"'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WS", "COMMENT", "IntegerLiteral", "StringLiteral", "True", 
			"False", "Self", "Create", "Become", "Display", "Send", "To", "If", "Else", 
			"For", "In", "Put", "Fun", "Return", "Call", "Identifier", "LParen", 
			"RParen", "LBracket", "RBracket", "LCurly", "RCurly", "Comma", "Semi", 
			"Assign", "Eq", "Neq", "Lower", "Leq", "Greater", "Geq", "And", "Or", 
			"Plus", "Minus", "Star", "Slash", "Percent", "Not"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0128\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\3\6\3d\n\3\r\3\16\3e\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6"+
		"\6{\n\6\r\6\16\6|\3\7\3\7\3\7\3\7\7\7\u0083\n\7\f\7\16\7\u0086\13\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u00dd\n\30\f\30\16\30\u00e0"+
		"\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3!\3!\5!\u00f6\n!\3\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u0100"+
		"\n#\3$\3$\3%\3%\3%\3%\3%\5%\u0109\n%\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u0112"+
		"\n\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\5/\u0127"+
		"\n/\3o\2\60\3\3\5\4\7\5\t\2\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33"+
		"\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67"+
		"\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/\3\2\7\5\2\13\f\17\17"+
		"\"\"\3\2\62;\3\2$$\5\2C\\aac|\6\2\62;C\\aac|\2\u0131\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5c\3\2\2\2\7i\3\2\2\2\tw\3\2\2\2\13"+
		"z\3\2\2\2\r~\3\2\2\2\17\u0089\3\2\2\2\21\u008e\3\2\2\2\23\u0094\3\2\2"+
		"\2\25\u0099\3\2\2\2\27\u00a0\3\2\2\2\31\u00a7\3\2\2\2\33\u00af\3\2\2\2"+
		"\35\u00b4\3\2\2\2\37\u00b7\3\2\2\2!\u00ba\3\2\2\2#\u00bf\3\2\2\2%\u00c3"+
		"\3\2\2\2\'\u00c6\3\2\2\2)\u00ca\3\2\2\2+\u00ce\3\2\2\2-\u00d5\3\2\2\2"+
		"/\u00da\3\2\2\2\61\u00e1\3\2\2\2\63\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67"+
		"\u00e7\3\2\2\29\u00e9\3\2\2\2;\u00eb\3\2\2\2=\u00ed\3\2\2\2?\u00ef\3\2"+
		"\2\2A\u00f5\3\2\2\2C\u00f7\3\2\2\2E\u00ff\3\2\2\2G\u0101\3\2\2\2I\u0108"+
		"\3\2\2\2K\u010a\3\2\2\2M\u0111\3\2\2\2O\u0113\3\2\2\2Q\u0116\3\2\2\2S"+
		"\u0119\3\2\2\2U\u011b\3\2\2\2W\u011d\3\2\2\2Y\u011f\3\2\2\2[\u0121\3\2"+
		"\2\2]\u0126\3\2\2\2_`\7\60\2\2`a\7\60\2\2a\4\3\2\2\2bd\t\2\2\2cb\3\2\2"+
		"\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\3\2\2h\6\3\2\2\2ij\7\61"+
		"\2\2jk\7,\2\2ko\3\2\2\2ln\13\2\2\2ml\3\2\2\2nq\3\2\2\2op\3\2\2\2om\3\2"+
		"\2\2pr\3\2\2\2qo\3\2\2\2rs\7,\2\2st\7\61\2\2tu\3\2\2\2uv\b\4\2\2v\b\3"+
		"\2\2\2wx\t\3\2\2x\n\3\2\2\2y{\5\t\5\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}"+
		"\3\2\2\2}\f\3\2\2\2~\u0084\7$\2\2\177\u0080\7^\2\2\u0080\u0083\13\2\2"+
		"\2\u0081\u0083\n\4\2\2\u0082\177\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0088\7$\2\2\u0088\16\3\2\2\2\u0089\u008a\7v\2\2"+
		"\u008a\u008b\7t\2\2\u008b\u008c\7w\2\2\u008c\u008d\7g\2\2\u008d\20\3\2"+
		"\2\2\u008e\u008f\7h\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2\u0091\u0092"+
		"\7u\2\2\u0092\u0093\7g\2\2\u0093\22\3\2\2\2\u0094\u0095\7u\2\2\u0095\u0096"+
		"\7g\2\2\u0096\u0097\7n\2\2\u0097\u0098\7h\2\2\u0098\24\3\2\2\2\u0099\u009a"+
		"\7e\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7v\2\2\u009e\u009f\7g\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7d\2\2\u00a1"+
		"\u00a2\7g\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7o\2\2"+
		"\u00a5\u00a6\7g\2\2\u00a6\30\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7"+
		"k\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7r\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad"+
		"\7c\2\2\u00ad\u00ae\7{\2\2\u00ae\32\3\2\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7f\2\2\u00b3\34\3\2\2\2\u00b4\u00b5"+
		"\7v\2\2\u00b5\u00b6\7q\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9"+
		"\7h\2\2\u00b9 \3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd"+
		"\7u\2\2\u00bd\u00be\7g\2\2\u00be\"\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1"+
		"\7q\2\2\u00c1\u00c2\7t\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5"+
		"\7p\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9"+
		"\7v\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7h\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd"+
		"\7p\2\2\u00cd*\3\2\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1"+
		"\7v\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		",\3\2\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8"+
		"\u00d9\7n\2\2\u00d9.\3\2\2\2\u00da\u00de\t\5\2\2\u00db\u00dd\t\6\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\60\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7*\2\2\u00e2\62"+
		"\3\2\2\2\u00e3\u00e4\7+\2\2\u00e4\64\3\2\2\2\u00e5\u00e6\7]\2\2\u00e6"+
		"\66\3\2\2\2\u00e7\u00e8\7_\2\2\u00e88\3\2\2\2\u00e9\u00ea\7}\2\2\u00ea"+
		":\3\2\2\2\u00eb\u00ec\7\177\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7.\2\2\u00ee"+
		">\3\2\2\2\u00ef\u00f0\7=\2\2\u00f0@\3\2\2\2\u00f1\u00f6\7?\2\2\u00f2\u00f3"+
		"\7\u00e4\2\2\u00f3\u00f4\7\u2022\2\2\u00f4\u00f6\7\uffff\2\2\u00f5\u00f1"+
		"\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7?\2\2\u00f8\u00f9"+
		"\7?\2\2\u00f9D\3\2\2\2\u00fa\u00fb\7#\2\2\u00fb\u0100\7?\2\2\u00fc\u00fd"+
		"\7\u00e4\2\2\u00fd\u00fe\7\u2032\2\2\u00fe\u0100\7\u00a2\2\2\u00ff\u00fa"+
		"\3\2\2\2\u00ff\u00fc\3\2\2\2\u0100F\3\2\2\2\u0101\u0102\7>\2\2\u0102H"+
		"\3\2\2\2\u0103\u0104\7>\2\2\u0104\u0109\7?\2\2\u0105\u0106\7\u00e4\2\2"+
		"\u0106\u0107\7\u2032\2\2\u0107\u0109\7\u00a6\2\2\u0108\u0103\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0109J\3\2\2\2\u010a\u010b\7@\2\2\u010bL\3\2\2\2\u010c"+
		"\u010d\7@\2\2\u010d\u0112\7?\2\2\u010e\u010f\7\u00e4\2\2\u010f\u0110\7"+
		"\u2032\2\2\u0110\u0112\7\u00a7\2\2\u0111\u010c\3\2\2\2\u0111\u010e\3\2"+
		"\2\2\u0112N\3\2\2\2\u0113\u0114\7(\2\2\u0114\u0115\7(\2\2\u0115P\3\2\2"+
		"\2\u0116\u0117\7~\2\2\u0117\u0118\7~\2\2\u0118R\3\2\2\2\u0119\u011a\7"+
		"-\2\2\u011aT\3\2\2\2\u011b\u011c\7/\2\2\u011cV\3\2\2\2\u011d\u011e\7,"+
		"\2\2\u011eX\3\2\2\2\u011f\u0120\7\61\2\2\u0120Z\3\2\2\2\u0121\u0122\7"+
		"\'\2\2\u0122\\\3\2\2\2\u0123\u0127\7#\2\2\u0124\u0125\7\u00c4\2\2\u0125"+
		"\u0127\7\u00ae\2\2\u0126\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0127^\3\2"+
		"\2\2\16\2eo|\u0082\u0084\u00de\u00f5\u00ff\u0108\u0111\u0126\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
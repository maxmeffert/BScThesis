package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
// Generated from Sql.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		K_ALTER=1, K_ADD=2, K_CREATE=3, K_COLUMN=4, K_CONSTRAIN=5, K_FOREIGN=6, 
		K_REFERENCES=7, K_TABLE=8, K_ENGINE=9, K_NOT=10, K_NULL=11, K_PRIMARY=12, 
		K_KEY=13, K_INSERT=14, K_INTO=15, K_VALUES=16, SCOL=17, DOT=18, OPEN_PAR=19, 
		CLOSE_PAR=20, COMMA=21, ASSIGN=22, STAR=23, PLUS=24, MINUS=25, TILDE=26, 
		PIPE2=27, DIV=28, MOD=29, LT2=30, GT2=31, AMP=32, PIPE=33, LT=34, LT_EQ=35, 
		GT=36, GT_EQ=37, EQ=38, NOT_EQ1=39, NOT_EQ2=40, IDENTIFIER=41, NUMERIC_LITERAL=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"K_ALTER", "K_ADD", "K_CREATE", "K_COLUMN", "K_CONSTRAIN", "K_FOREIGN", 
		"K_REFERENCES", "K_TABLE", "K_ENGINE", "K_NOT", "K_NULL", "K_PRIMARY", 
		"K_KEY", "K_INSERT", "K_INTO", "K_VALUES", "SCOL", "DOT", "OPEN_PAR", 
		"CLOSE_PAR", "COMMA", "ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", "PIPE2", 
		"DIV", "MOD", "LT2", "GT2", "AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", 
		"EQ", "NOT_EQ1", "NOT_EQ2", "IDENTIFIER", "NUMERIC_LITERAL", "DIGIT", 
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "';'", "'.'", "'('", "')'", "','", "'='", 
		"'*'", "'+'", "'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", 
		"'|'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'<>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "K_ALTER", "K_ADD", "K_CREATE", "K_COLUMN", "K_CONSTRAIN", "K_FOREIGN", 
		"K_REFERENCES", "K_TABLE", "K_ENGINE", "K_NOT", "K_NULL", "K_PRIMARY", 
		"K_KEY", "K_INSERT", "K_INTO", "K_VALUES", "SCOL", "DOT", "OPEN_PAR", 
		"CLOSE_PAR", "COMMA", "ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", "PIPE2", 
		"DIV", "MOD", "LT2", "GT2", "AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", 
		"EQ", "NOT_EQ1", "NOT_EQ2", "IDENTIFIER", "NUMERIC_LITERAL"
	};
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


	public SqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u01b7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\7*\u0135\n*\f"+
		"*\16*\u0138\13*\3*\3*\3*\3*\3*\7*\u013f\n*\f*\16*\u0142\13*\3*\3*\3*\7"+
		"*\u0147\n*\f*\16*\u014a\13*\3*\3*\3*\7*\u014f\n*\f*\16*\u0152\13*\5*\u0154"+
		"\n*\3+\6+\u0157\n+\r+\16+\u0158\3+\3+\7+\u015d\n+\f+\16+\u0160\13+\5+"+
		"\u0162\n+\3+\3+\5+\u0166\n+\3+\6+\u0169\n+\r+\16+\u016a\5+\u016d\n+\3"+
		"+\3+\6+\u0171\n+\r+\16+\u0172\3+\3+\5+\u0177\n+\3+\6+\u017a\n+\r+\16+"+
		"\u017b\5+\u017e\n+\5+\u0180\n+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3"+
		"D\3D\3E\3E\3F\3F\2\2G\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W\2Y\2[\2]\2_\2a\2c\2"+
		"e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2"+
		"\u0087\2\u0089\2\u008b\2\3\2#\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\"+
		"aac|\4\2--//\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4"+
		"\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQq"+
		"q\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2"+
		"ZZzz\4\2[[{{\4\2\\\\||\2\u01af\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3\u008d\3\2\2\2\5\u0093\3\2\2"+
		"\2\7\u0097\3\2\2\2\t\u009e\3\2\2\2\13\u00a5\3\2\2\2\r\u00b0\3\2\2\2\17"+
		"\u00b8\3\2\2\2\21\u00c3\3\2\2\2\23\u00c9\3\2\2\2\25\u00d0\3\2\2\2\27\u00d4"+
		"\3\2\2\2\31\u00d9\3\2\2\2\33\u00e1\3\2\2\2\35\u00e5\3\2\2\2\37\u00ec\3"+
		"\2\2\2!\u00f1\3\2\2\2#\u00f8\3\2\2\2%\u00fa\3\2\2\2\'\u00fc\3\2\2\2)\u00fe"+
		"\3\2\2\2+\u0100\3\2\2\2-\u0102\3\2\2\2/\u0104\3\2\2\2\61\u0106\3\2\2\2"+
		"\63\u0108\3\2\2\2\65\u010a\3\2\2\2\67\u010c\3\2\2\29\u010f\3\2\2\2;\u0111"+
		"\3\2\2\2=\u0113\3\2\2\2?\u0116\3\2\2\2A\u0119\3\2\2\2C\u011b\3\2\2\2E"+
		"\u011d\3\2\2\2G\u011f\3\2\2\2I\u0122\3\2\2\2K\u0124\3\2\2\2M\u0127\3\2"+
		"\2\2O\u012a\3\2\2\2Q\u012d\3\2\2\2S\u0153\3\2\2\2U\u017f\3\2\2\2W\u0181"+
		"\3\2\2\2Y\u0183\3\2\2\2[\u0185\3\2\2\2]\u0187\3\2\2\2_\u0189\3\2\2\2a"+
		"\u018b\3\2\2\2c\u018d\3\2\2\2e\u018f\3\2\2\2g\u0191\3\2\2\2i\u0193\3\2"+
		"\2\2k\u0195\3\2\2\2m\u0197\3\2\2\2o\u0199\3\2\2\2q\u019b\3\2\2\2s\u019d"+
		"\3\2\2\2u\u019f\3\2\2\2w\u01a1\3\2\2\2y\u01a3\3\2\2\2{\u01a5\3\2\2\2}"+
		"\u01a7\3\2\2\2\177\u01a9\3\2\2\2\u0081\u01ab\3\2\2\2\u0083\u01ad\3\2\2"+
		"\2\u0085\u01af\3\2\2\2\u0087\u01b1\3\2\2\2\u0089\u01b3\3\2\2\2\u008b\u01b5"+
		"\3\2\2\2\u008d\u008e\5Y-\2\u008e\u008f\5o8\2\u008f\u0090\5\177@\2\u0090"+
		"\u0091\5a\61\2\u0091\u0092\5{>\2\u0092\4\3\2\2\2\u0093\u0094\5Y-\2\u0094"+
		"\u0095\5_\60\2\u0095\u0096\5_\60\2\u0096\6\3\2\2\2\u0097\u0098\5]/\2\u0098"+
		"\u0099\5{>\2\u0099\u009a\5a\61\2\u009a\u009b\5Y-\2\u009b\u009c\5\177@"+
		"\2\u009c\u009d\5a\61\2\u009d\b\3\2\2\2\u009e\u009f\5]/\2\u009f\u00a0\5"+
		"u;\2\u00a0\u00a1\5o8\2\u00a1\u00a2\5\u0081A\2\u00a2\u00a3\5q9\2\u00a3"+
		"\u00a4\5s:\2\u00a4\n\3\2\2\2\u00a5\u00a6\5]/\2\u00a6\u00a7\5u;\2\u00a7"+
		"\u00a8\5s:\2\u00a8\u00a9\5}?\2\u00a9\u00aa\5\177@\2\u00aa\u00ab\5{>\2"+
		"\u00ab\u00ac\5Y-\2\u00ac\u00ad\5i\65\2\u00ad\u00ae\5s:\2\u00ae\u00af\5"+
		"\177@\2\u00af\f\3\2\2\2\u00b0\u00b1\5c\62\2\u00b1\u00b2\5u;\2\u00b2\u00b3"+
		"\5{>\2\u00b3\u00b4\5a\61\2\u00b4\u00b5\5i\65\2\u00b5\u00b6\5e\63\2\u00b6"+
		"\u00b7\5s:\2\u00b7\16\3\2\2\2\u00b8\u00b9\5{>\2\u00b9\u00ba\5a\61\2\u00ba"+
		"\u00bb\5c\62\2\u00bb\u00bc\5a\61\2\u00bc\u00bd\5{>\2\u00bd\u00be\5a\61"+
		"\2\u00be\u00bf\5s:\2\u00bf\u00c0\5]/\2\u00c0\u00c1\5a\61\2\u00c1\u00c2"+
		"\5}?\2\u00c2\20\3\2\2\2\u00c3\u00c4\5\177@\2\u00c4\u00c5\5Y-\2\u00c5\u00c6"+
		"\5[.\2\u00c6\u00c7\5o8\2\u00c7\u00c8\5a\61\2\u00c8\22\3\2\2\2\u00c9\u00ca"+
		"\5a\61\2\u00ca\u00cb\5s:\2\u00cb\u00cc\5e\63\2\u00cc\u00cd\5i\65\2\u00cd"+
		"\u00ce\5s:\2\u00ce\u00cf\5a\61\2\u00cf\24\3\2\2\2\u00d0\u00d1\5s:\2\u00d1"+
		"\u00d2\5u;\2\u00d2\u00d3\5\177@\2\u00d3\26\3\2\2\2\u00d4\u00d5\5s:\2\u00d5"+
		"\u00d6\5\u0081A\2\u00d6\u00d7\5o8\2\u00d7\u00d8\5o8\2\u00d8\30\3\2\2\2"+
		"\u00d9\u00da\5w<\2\u00da\u00db\5{>\2\u00db\u00dc\5i\65\2\u00dc\u00dd\5"+
		"q9\2\u00dd\u00de\5Y-\2\u00de\u00df\5{>\2\u00df\u00e0\5\u0089E\2\u00e0"+
		"\32\3\2\2\2\u00e1\u00e2\5m\67\2\u00e2\u00e3\5a\61\2\u00e3\u00e4\5\u0089"+
		"E\2\u00e4\34\3\2\2\2\u00e5\u00e6\5i\65\2\u00e6\u00e7\5s:\2\u00e7\u00e8"+
		"\5}?\2\u00e8\u00e9\5a\61\2\u00e9\u00ea\5{>\2\u00ea\u00eb\5\177@\2\u00eb"+
		"\36\3\2\2\2\u00ec\u00ed\5i\65\2\u00ed\u00ee\5s:\2\u00ee\u00ef\5\177@\2"+
		"\u00ef\u00f0\5u;\2\u00f0 \3\2\2\2\u00f1\u00f2\5\u0083B\2\u00f2\u00f3\5"+
		"Y-\2\u00f3\u00f4\5o8\2\u00f4\u00f5\5\u0081A\2\u00f5\u00f6\5a\61\2\u00f6"+
		"\u00f7\5}?\2\u00f7\"\3\2\2\2\u00f8\u00f9\7=\2\2\u00f9$\3\2\2\2\u00fa\u00fb"+
		"\7\60\2\2\u00fb&\3\2\2\2\u00fc\u00fd\7*\2\2\u00fd(\3\2\2\2\u00fe\u00ff"+
		"\7+\2\2\u00ff*\3\2\2\2\u0100\u0101\7.\2\2\u0101,\3\2\2\2\u0102\u0103\7"+
		"?\2\2\u0103.\3\2\2\2\u0104\u0105\7,\2\2\u0105\60\3\2\2\2\u0106\u0107\7"+
		"-\2\2\u0107\62\3\2\2\2\u0108\u0109\7/\2\2\u0109\64\3\2\2\2\u010a\u010b"+
		"\7\u0080\2\2\u010b\66\3\2\2\2\u010c\u010d\7~\2\2\u010d\u010e\7~\2\2\u010e"+
		"8\3\2\2\2\u010f\u0110\7\61\2\2\u0110:\3\2\2\2\u0111\u0112\7\'\2\2\u0112"+
		"<\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115\7>\2\2\u0115>\3\2\2\2\u0116\u0117"+
		"\7@\2\2\u0117\u0118\7@\2\2\u0118@\3\2\2\2\u0119\u011a\7(\2\2\u011aB\3"+
		"\2\2\2\u011b\u011c\7~\2\2\u011cD\3\2\2\2\u011d\u011e\7>\2\2\u011eF\3\2"+
		"\2\2\u011f\u0120\7>\2\2\u0120\u0121\7?\2\2\u0121H\3\2\2\2\u0122\u0123"+
		"\7@\2\2\u0123J\3\2\2\2\u0124\u0125\7@\2\2\u0125\u0126\7?\2\2\u0126L\3"+
		"\2\2\2\u0127\u0128\7?\2\2\u0128\u0129\7?\2\2\u0129N\3\2\2\2\u012a\u012b"+
		"\7#\2\2\u012b\u012c\7?\2\2\u012cP\3\2\2\2\u012d\u012e\7>\2\2\u012e\u012f"+
		"\7@\2\2\u012fR\3\2\2\2\u0130\u0136\7$\2\2\u0131\u0135\n\2\2\2\u0132\u0133"+
		"\7$\2\2\u0133\u0135\7$\2\2\u0134\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139\3\2"+
		"\2\2\u0138\u0136\3\2\2\2\u0139\u0154\7$\2\2\u013a\u0140\7b\2\2\u013b\u013f"+
		"\n\3\2\2\u013c\u013d\7b\2\2\u013d\u013f\7b\2\2\u013e\u013b\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0154\7b\2\2\u0144"+
		"\u0148\7]\2\2\u0145\u0147\n\4\2\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2"+
		"\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u0154\7_\2\2\u014c\u0150\t\5\2\2\u014d\u014f\t\6"+
		"\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0130\3\2"+
		"\2\2\u0153\u013a\3\2\2\2\u0153\u0144\3\2\2\2\u0153\u014c\3\2\2\2\u0154"+
		"T\3\2\2\2\u0155\u0157\5W,\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0161\3\2\2\2\u015a\u015e\7\60"+
		"\2\2\u015b\u015d\5W,\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0161"+
		"\u015a\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u016c\3\2\2\2\u0163\u0165\5a"+
		"\61\2\u0164\u0166\t\7\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0168\3\2\2\2\u0167\u0169\5W,\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2"+
		"\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u0163"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0180\3\2\2\2\u016e\u0170\7\60\2\2"+
		"\u016f\u0171\5W,\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017d\3\2\2\2\u0174\u0176\5a\61\2\u0175"+
		"\u0177\t\7\2\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2"+
		"\2\2\u0178\u017a\5W,\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0179"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u0174\3\2\2\2\u017d"+
		"\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0156\3\2\2\2\u017f\u016e\3\2"+
		"\2\2\u0180V\3\2\2\2\u0181\u0182\t\b\2\2\u0182X\3\2\2\2\u0183\u0184\t\t"+
		"\2\2\u0184Z\3\2\2\2\u0185\u0186\t\n\2\2\u0186\\\3\2\2\2\u0187\u0188\t"+
		"\13\2\2\u0188^\3\2\2\2\u0189\u018a\t\f\2\2\u018a`\3\2\2\2\u018b\u018c"+
		"\t\r\2\2\u018cb\3\2\2\2\u018d\u018e\t\16\2\2\u018ed\3\2\2\2\u018f\u0190"+
		"\t\17\2\2\u0190f\3\2\2\2\u0191\u0192\t\20\2\2\u0192h\3\2\2\2\u0193\u0194"+
		"\t\21\2\2\u0194j\3\2\2\2\u0195\u0196\t\22\2\2\u0196l\3\2\2\2\u0197\u0198"+
		"\t\23\2\2\u0198n\3\2\2\2\u0199\u019a\t\24\2\2\u019ap\3\2\2\2\u019b\u019c"+
		"\t\25\2\2\u019cr\3\2\2\2\u019d\u019e\t\26\2\2\u019et\3\2\2\2\u019f\u01a0"+
		"\t\27\2\2\u01a0v\3\2\2\2\u01a1\u01a2\t\30\2\2\u01a2x\3\2\2\2\u01a3\u01a4"+
		"\t\31\2\2\u01a4z\3\2\2\2\u01a5\u01a6\t\32\2\2\u01a6|\3\2\2\2\u01a7\u01a8"+
		"\t\33\2\2\u01a8~\3\2\2\2\u01a9\u01aa\t\34\2\2\u01aa\u0080\3\2\2\2\u01ab"+
		"\u01ac\t\35\2\2\u01ac\u0082\3\2\2\2\u01ad\u01ae\t\36\2\2\u01ae\u0084\3"+
		"\2\2\2\u01af\u01b0\t\37\2\2\u01b0\u0086\3\2\2\2\u01b1\u01b2\t \2\2\u01b2"+
		"\u0088\3\2\2\2\u01b3\u01b4\t!\2\2\u01b4\u008a\3\2\2\2\u01b5\u01b6\t\""+
		"\2\2\u01b6\u008c\3\2\2\2\25\2\u0134\u0136\u013e\u0140\u0148\u0150\u0153"+
		"\u0158\u015e\u0161\u0165\u016a\u016c\u0172\u0176\u017b\u017d\u017f\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
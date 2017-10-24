// Generated from /home/darjeeling/Documents/BScThesis/code/org.softlang.maxmeffert.bscthesis/src/main/java/org/softlang/maxmeffert/bscthesis/ccrecovery/scenarios/languages/sql/antlr/Sql.g4 by ANTLR 4.7
package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
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
		T__0=1, T__1=2, K_CREATE=3, K_TABLE=4, IDENTIFIER=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "K_CREATE", "K_TABLE", "IDENTIFIER", "DIGIT", "A", "B", 
		"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
		"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "K_CREATE", "K_TABLE", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u00af\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\3\6\3\6\3\6\7\6c\n"+
		"\6\f\6\16\6f\13\6\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\6\3\6\3\6\7\6"+
		"s\n\6\f\6\16\6v\13\6\5\6x\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\2"+
		"\2\"\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2"+
		"\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2\3\2"+
		"\"\3\2$$\3\2bb\3\2__\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2CCcc\4\2DDd"+
		"d\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2"+
		"MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4"+
		"\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u009c\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3C\3\2\2\2\5E"+
		"\3\2\2\2\7G\3\2\2\2\tN\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21}"+
		"\3\2\2\2\23\177\3\2\2\2\25\u0081\3\2\2\2\27\u0083\3\2\2\2\31\u0085\3\2"+
		"\2\2\33\u0087\3\2\2\2\35\u0089\3\2\2\2\37\u008b\3\2\2\2!\u008d\3\2\2\2"+
		"#\u008f\3\2\2\2%\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2+\u0097\3"+
		"\2\2\2-\u0099\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u009f\3\2\2\2"+
		"\65\u00a1\3\2\2\2\67\u00a3\3\2\2\29\u00a5\3\2\2\2;\u00a7\3\2\2\2=\u00a9"+
		"\3\2\2\2?\u00ab\3\2\2\2A\u00ad\3\2\2\2CD\7*\2\2D\4\3\2\2\2EF\7+\2\2F\6"+
		"\3\2\2\2GH\5\23\n\2HI\5\61\31\2IJ\5\27\f\2JK\5\17\b\2KL\5\65\33\2LM\5"+
		"\27\f\2M\b\3\2\2\2NO\5\65\33\2OP\5\17\b\2PQ\5\21\t\2QR\5%\23\2RS\5\27"+
		"\f\2S\n\3\2\2\2TZ\7$\2\2UY\n\2\2\2VW\7$\2\2WY\7$\2\2XU\3\2\2\2XV\3\2\2"+
		"\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]x\7$\2\2^d\7b\2"+
		"\2_c\n\3\2\2`a\7b\2\2ac\7b\2\2b_\3\2\2\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gx\7b\2\2hl\7]\2\2ik\n\4\2\2ji\3\2\2\2k"+
		"n\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2ox\7_\2\2pt\t\5\2\2q"+
		"s\t\6\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2"+
		"wT\3\2\2\2w^\3\2\2\2wh\3\2\2\2wp\3\2\2\2x\f\3\2\2\2yz\t\7\2\2z\16\3\2"+
		"\2\2{|\t\b\2\2|\20\3\2\2\2}~\t\t\2\2~\22\3\2\2\2\177\u0080\t\n\2\2\u0080"+
		"\24\3\2\2\2\u0081\u0082\t\13\2\2\u0082\26\3\2\2\2\u0083\u0084\t\f\2\2"+
		"\u0084\30\3\2\2\2\u0085\u0086\t\r\2\2\u0086\32\3\2\2\2\u0087\u0088\t\16"+
		"\2\2\u0088\34\3\2\2\2\u0089\u008a\t\17\2\2\u008a\36\3\2\2\2\u008b\u008c"+
		"\t\20\2\2\u008c \3\2\2\2\u008d\u008e\t\21\2\2\u008e\"\3\2\2\2\u008f\u0090"+
		"\t\22\2\2\u0090$\3\2\2\2\u0091\u0092\t\23\2\2\u0092&\3\2\2\2\u0093\u0094"+
		"\t\24\2\2\u0094(\3\2\2\2\u0095\u0096\t\25\2\2\u0096*\3\2\2\2\u0097\u0098"+
		"\t\26\2\2\u0098,\3\2\2\2\u0099\u009a\t\27\2\2\u009a.\3\2\2\2\u009b\u009c"+
		"\t\30\2\2\u009c\60\3\2\2\2\u009d\u009e\t\31\2\2\u009e\62\3\2\2\2\u009f"+
		"\u00a0\t\32\2\2\u00a0\64\3\2\2\2\u00a1\u00a2\t\33\2\2\u00a2\66\3\2\2\2"+
		"\u00a3\u00a4\t\34\2\2\u00a48\3\2\2\2\u00a5\u00a6\t\35\2\2\u00a6:\3\2\2"+
		"\2\u00a7\u00a8\t\36\2\2\u00a8<\3\2\2\2\u00a9\u00aa\t\37\2\2\u00aa>\3\2"+
		"\2\2\u00ab\u00ac\t \2\2\u00ac@\3\2\2\2\u00ad\u00ae\t!\2\2\u00aeB\3\2\2"+
		"\2\n\2XZbdltw\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
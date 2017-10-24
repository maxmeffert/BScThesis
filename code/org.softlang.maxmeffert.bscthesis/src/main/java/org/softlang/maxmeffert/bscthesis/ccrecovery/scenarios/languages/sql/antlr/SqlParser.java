package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
// Generated from Sql.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlParser extends Parser {
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
	public static final int
		RULE_sqlDocument = 0, RULE_sqlStatement = 1, RULE_sqlStatements = 2, RULE_sqlDdlStatement = 3, 
		RULE_sqlDmlStatement = 4, RULE_sqlCreateTableStatement = 5, RULE_sqlTableName = 6, 
		RULE_sqlColumnDefinitions = 7, RULE_sqlColumnDefinition = 8, RULE_sqlColumnName = 9, 
		RULE_sqlColumnNames = 10, RULE_sqlColumnType = 11, RULE_sqlColumnTypeName = 12, 
		RULE_sqlColumnConstrain = 13, RULE_sqlTableContstrain = 14, RULE_sqlTableEngine = 15, 
		RULE_sqlTableEngineName = 16, RULE_sqlAlterTableStatement = 17, RULE_sqlAddTableConstraint = 18, 
		RULE_sqlInsertStatement = 19, RULE_identifier = 20, RULE_signedNumber = 21;
	public static final String[] ruleNames = {
		"sqlDocument", "sqlStatement", "sqlStatements", "sqlDdlStatement", "sqlDmlStatement", 
		"sqlCreateTableStatement", "sqlTableName", "sqlColumnDefinitions", "sqlColumnDefinition", 
		"sqlColumnName", "sqlColumnNames", "sqlColumnType", "sqlColumnTypeName", 
		"sqlColumnConstrain", "sqlTableContstrain", "sqlTableEngine", "sqlTableEngineName", 
		"sqlAlterTableStatement", "sqlAddTableConstraint", "sqlInsertStatement", 
		"identifier", "signedNumber"
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

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SqlDocumentContext extends ParserRuleContext {
		public SqlStatementsContext sqlStatements() {
			return getRuleContext(SqlStatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlParser.EOF, 0); }
		public SqlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlDocument(this);
		}
	}

	public final SqlDocumentContext sqlDocument() throws RecognitionException {
		SqlDocumentContext _localctx = new SqlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlDocument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			sqlStatements();
			setState(45);
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

	public static class SqlStatementContext extends ParserRuleContext {
		public SqlDdlStatementContext sqlDdlStatement() {
			return getRuleContext(SqlDdlStatementContext.class,0);
		}
		public SqlDmlStatementContext sqlDmlStatement() {
			return getRuleContext(SqlDmlStatementContext.class,0);
		}
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlStatement(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sqlStatement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_ALTER:
			case K_CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				sqlDdlStatement();
				}
				break;
			case K_INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				sqlDmlStatement();
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

	public static class SqlStatementsContext extends ParserRuleContext {
		public List<SqlStatementContext> sqlStatement() {
			return getRuleContexts(SqlStatementContext.class);
		}
		public SqlStatementContext sqlStatement(int i) {
			return getRuleContext(SqlStatementContext.class,i);
		}
		public SqlStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlStatements(this);
		}
	}

	public final SqlStatementsContext sqlStatements() throws RecognitionException {
		SqlStatementsContext _localctx = new SqlStatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sqlStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ALTER) | (1L << K_CREATE) | (1L << K_INSERT))) != 0)) {
				{
				{
				setState(51);
				sqlStatement();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SqlDdlStatementContext extends ParserRuleContext {
		public SqlCreateTableStatementContext sqlCreateTableStatement() {
			return getRuleContext(SqlCreateTableStatementContext.class,0);
		}
		public SqlAlterTableStatementContext sqlAlterTableStatement() {
			return getRuleContext(SqlAlterTableStatementContext.class,0);
		}
		public SqlDdlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlDdlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlDdlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlDdlStatement(this);
		}
	}

	public final SqlDdlStatementContext sqlDdlStatement() throws RecognitionException {
		SqlDdlStatementContext _localctx = new SqlDdlStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sqlDdlStatement);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				sqlCreateTableStatement();
				}
				break;
			case K_ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				sqlAlterTableStatement();
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

	public static class SqlDmlStatementContext extends ParserRuleContext {
		public SqlInsertStatementContext sqlInsertStatement() {
			return getRuleContext(SqlInsertStatementContext.class,0);
		}
		public SqlDmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlDmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlDmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlDmlStatement(this);
		}
	}

	public final SqlDmlStatementContext sqlDmlStatement() throws RecognitionException {
		SqlDmlStatementContext _localctx = new SqlDmlStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sqlDmlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			sqlInsertStatement();
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

	public static class SqlCreateTableStatementContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SqlParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public SqlTableNameContext sqlTableName() {
			return getRuleContext(SqlTableNameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SqlParser.OPEN_PAR, 0); }
		public SqlColumnDefinitionsContext sqlColumnDefinitions() {
			return getRuleContext(SqlColumnDefinitionsContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlParser.CLOSE_PAR, 0); }
		public SqlTableEngineContext sqlTableEngine() {
			return getRuleContext(SqlTableEngineContext.class,0);
		}
		public SqlCreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlCreateTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlCreateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlCreateTableStatement(this);
		}
	}

	public final SqlCreateTableStatementContext sqlCreateTableStatement() throws RecognitionException {
		SqlCreateTableStatementContext _localctx = new SqlCreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sqlCreateTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(K_CREATE);
			setState(64);
			match(K_TABLE);
			setState(65);
			sqlTableName();
			setState(66);
			match(OPEN_PAR);
			setState(67);
			sqlColumnDefinitions();
			setState(68);
			match(CLOSE_PAR);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ENGINE) {
				{
				setState(69);
				sqlTableEngine();
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

	public static class SqlTableNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SqlTableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlTableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlTableName(this);
		}
	}

	public final SqlTableNameContext sqlTableName() throws RecognitionException {
		SqlTableNameContext _localctx = new SqlTableNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sqlTableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
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

	public static class SqlColumnDefinitionsContext extends ParserRuleContext {
		public List<SqlColumnDefinitionContext> sqlColumnDefinition() {
			return getRuleContexts(SqlColumnDefinitionContext.class);
		}
		public SqlColumnDefinitionContext sqlColumnDefinition(int i) {
			return getRuleContext(SqlColumnDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public List<SqlTableContstrainContext> sqlTableContstrain() {
			return getRuleContexts(SqlTableContstrainContext.class);
		}
		public SqlTableContstrainContext sqlTableContstrain(int i) {
			return getRuleContext(SqlTableContstrainContext.class,i);
		}
		public SqlColumnDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnDefinitions(this);
		}
	}

	public final SqlColumnDefinitionsContext sqlColumnDefinitions() throws RecognitionException {
		SqlColumnDefinitionsContext _localctx = new SqlColumnDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sqlColumnDefinitions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			sqlColumnDefinition();
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(75);
					match(COMMA);
					setState(76);
					sqlColumnDefinition();
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				sqlTableContstrain();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SqlColumnDefinitionContext extends ParserRuleContext {
		public SqlColumnNameContext sqlColumnName() {
			return getRuleContext(SqlColumnNameContext.class,0);
		}
		public SqlColumnTypeContext sqlColumnType() {
			return getRuleContext(SqlColumnTypeContext.class,0);
		}
		public SqlColumnConstrainContext sqlColumnConstrain() {
			return getRuleContext(SqlColumnConstrainContext.class,0);
		}
		public SqlColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnDefinition(this);
		}
	}

	public final SqlColumnDefinitionContext sqlColumnDefinition() throws RecognitionException {
		SqlColumnDefinitionContext _localctx = new SqlColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sqlColumnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			sqlColumnName();
			setState(90);
			sqlColumnType();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_NOT || _la==K_NULL) {
				{
				setState(91);
				sqlColumnConstrain();
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

	public static class SqlColumnNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SqlColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnName(this);
		}
	}

	public final SqlColumnNameContext sqlColumnName() throws RecognitionException {
		SqlColumnNameContext _localctx = new SqlColumnNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sqlColumnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
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

	public static class SqlColumnNamesContext extends ParserRuleContext {
		public List<SqlColumnNameContext> sqlColumnName() {
			return getRuleContexts(SqlColumnNameContext.class);
		}
		public SqlColumnNameContext sqlColumnName(int i) {
			return getRuleContext(SqlColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SqlColumnNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnNames(this);
		}
	}

	public final SqlColumnNamesContext sqlColumnNames() throws RecognitionException {
		SqlColumnNamesContext _localctx = new SqlColumnNamesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sqlColumnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			sqlColumnName();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				sqlColumnName();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SqlColumnTypeContext extends ParserRuleContext {
		public SqlColumnTypeNameContext sqlColumnTypeName() {
			return getRuleContext(SqlColumnTypeNameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SqlParser.OPEN_PAR, 0); }
		public SignedNumberContext signedNumber() {
			return getRuleContext(SignedNumberContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlParser.CLOSE_PAR, 0); }
		public SqlColumnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnType(this);
		}
	}

	public final SqlColumnTypeContext sqlColumnType() throws RecognitionException {
		SqlColumnTypeContext _localctx = new SqlColumnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sqlColumnType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			sqlColumnTypeName();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(105);
				match(OPEN_PAR);
				setState(106);
				signedNumber();
				setState(107);
				match(CLOSE_PAR);
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

	public static class SqlColumnTypeNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public SqlColumnTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnTypeName(this);
		}
	}

	public final SqlColumnTypeNameContext sqlColumnTypeName() throws RecognitionException {
		SqlColumnTypeNameContext _localctx = new SqlColumnTypeNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sqlColumnTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				identifier();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
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

	public static class SqlColumnConstrainContext extends ParserRuleContext {
		public TerminalNode K_NULL() { return getToken(SqlParser.K_NULL, 0); }
		public TerminalNode K_NOT() { return getToken(SqlParser.K_NOT, 0); }
		public SqlColumnConstrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlColumnConstrain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlColumnConstrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlColumnConstrain(this);
		}
	}

	public final SqlColumnConstrainContext sqlColumnConstrain() throws RecognitionException {
		SqlColumnConstrainContext _localctx = new SqlColumnConstrainContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sqlColumnConstrain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(116);
				match(K_NOT);
				}
			}

			setState(119);
			match(K_NULL);
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

	public static class SqlTableContstrainContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(SqlParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(SqlParser.K_KEY, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SqlParser.OPEN_PAR, 0); }
		public List<SqlColumnNameContext> sqlColumnName() {
			return getRuleContexts(SqlColumnNameContext.class);
		}
		public SqlColumnNameContext sqlColumnName(int i) {
			return getRuleContext(SqlColumnNameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SqlTableContstrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlTableContstrain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlTableContstrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlTableContstrain(this);
		}
	}

	public final SqlTableContstrainContext sqlTableContstrain() throws RecognitionException {
		SqlTableContstrainContext _localctx = new SqlTableContstrainContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sqlTableContstrain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(K_PRIMARY);
			setState(122);
			match(K_KEY);
			setState(123);
			match(OPEN_PAR);
			setState(124);
			sqlColumnName();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(125);
				match(COMMA);
				setState(126);
				sqlColumnName();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(CLOSE_PAR);
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

	public static class SqlTableEngineContext extends ParserRuleContext {
		public TerminalNode K_ENGINE() { return getToken(SqlParser.K_ENGINE, 0); }
		public TerminalNode ASSIGN() { return getToken(SqlParser.ASSIGN, 0); }
		public SqlTableEngineNameContext sqlTableEngineName() {
			return getRuleContext(SqlTableEngineNameContext.class,0);
		}
		public SqlTableEngineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlTableEngine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlTableEngine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlTableEngine(this);
		}
	}

	public final SqlTableEngineContext sqlTableEngine() throws RecognitionException {
		SqlTableEngineContext _localctx = new SqlTableEngineContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sqlTableEngine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(K_ENGINE);
			setState(135);
			match(ASSIGN);
			setState(136);
			sqlTableEngineName();
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

	public static class SqlTableEngineNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SqlTableEngineNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlTableEngineName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlTableEngineName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlTableEngineName(this);
		}
	}

	public final SqlTableEngineNameContext sqlTableEngineName() throws RecognitionException {
		SqlTableEngineNameContext _localctx = new SqlTableEngineNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sqlTableEngineName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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

	public static class SqlAlterTableStatementContext extends ParserRuleContext {
		public TerminalNode K_ALTER() { return getToken(SqlParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(SqlParser.K_TABLE, 0); }
		public SqlTableNameContext sqlTableName() {
			return getRuleContext(SqlTableNameContext.class,0);
		}
		public SqlAddTableConstraintContext sqlAddTableConstraint() {
			return getRuleContext(SqlAddTableConstraintContext.class,0);
		}
		public SqlAlterTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlAlterTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlAlterTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlAlterTableStatement(this);
		}
	}

	public final SqlAlterTableStatementContext sqlAlterTableStatement() throws RecognitionException {
		SqlAlterTableStatementContext _localctx = new SqlAlterTableStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sqlAlterTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(K_ALTER);
			setState(141);
			match(K_TABLE);
			setState(142);
			sqlTableName();
			setState(143);
			sqlAddTableConstraint();
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

	public static class SqlAddTableConstraintContext extends ParserRuleContext {
		public TerminalNode K_ADD() { return getToken(SqlParser.K_ADD, 0); }
		public TerminalNode K_CONSTRAIN() { return getToken(SqlParser.K_CONSTRAIN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode K_FOREIGN() { return getToken(SqlParser.K_FOREIGN, 0); }
		public TerminalNode K_KEY() { return getToken(SqlParser.K_KEY, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SqlParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SqlParser.OPEN_PAR, i);
		}
		public List<SqlColumnNamesContext> sqlColumnNames() {
			return getRuleContexts(SqlColumnNamesContext.class);
		}
		public SqlColumnNamesContext sqlColumnNames(int i) {
			return getRuleContext(SqlColumnNamesContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SqlParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SqlParser.CLOSE_PAR, i);
		}
		public TerminalNode K_REFERENCES() { return getToken(SqlParser.K_REFERENCES, 0); }
		public SqlTableNameContext sqlTableName() {
			return getRuleContext(SqlTableNameContext.class,0);
		}
		public SqlAddTableConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlAddTableConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlAddTableConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlAddTableConstraint(this);
		}
	}

	public final SqlAddTableConstraintContext sqlAddTableConstraint() throws RecognitionException {
		SqlAddTableConstraintContext _localctx = new SqlAddTableConstraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sqlAddTableConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(K_ADD);
			setState(146);
			match(K_CONSTRAIN);
			setState(147);
			identifier();
			setState(148);
			match(K_FOREIGN);
			setState(149);
			match(K_KEY);
			setState(150);
			match(OPEN_PAR);
			setState(151);
			sqlColumnNames();
			setState(152);
			match(CLOSE_PAR);
			setState(153);
			match(K_REFERENCES);
			setState(154);
			sqlTableName();
			setState(155);
			match(OPEN_PAR);
			setState(156);
			sqlColumnNames();
			setState(157);
			match(CLOSE_PAR);
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

	public static class SqlInsertStatementContext extends ParserRuleContext {
		public TerminalNode K_INSERT() { return getToken(SqlParser.K_INSERT, 0); }
		public TerminalNode K_INTO() { return getToken(SqlParser.K_INTO, 0); }
		public SqlTableNameContext sqlTableName() {
			return getRuleContext(SqlTableNameContext.class,0);
		}
		public TerminalNode K_VALUES() { return getToken(SqlParser.K_VALUES, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SqlParser.OPEN_PAR, 0); }
		public List<SignedNumberContext> signedNumber() {
			return getRuleContexts(SignedNumberContext.class);
		}
		public SignedNumberContext signedNumber(int i) {
			return getRuleContext(SignedNumberContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SqlParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SqlInsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlInsertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSqlInsertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSqlInsertStatement(this);
		}
	}

	public final SqlInsertStatementContext sqlInsertStatement() throws RecognitionException {
		SqlInsertStatementContext _localctx = new SqlInsertStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sqlInsertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(K_INSERT);
			setState(160);
			match(K_INTO);
			setState(161);
			sqlTableName();
			setState(162);
			match(K_VALUES);
			setState(163);
			match(OPEN_PAR);
			setState(164);
			signedNumber();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(165);
				match(COMMA);
				setState(166);
				signedNumber();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(CLOSE_PAR);
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
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(IDENTIFIER);
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

	public static class SignedNumberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SqlParser.NUMERIC_LITERAL, 0); }
		public SignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSignedNumber(this);
		}
	}

	public final SignedNumberContext signedNumber() throws RecognitionException {
		SignedNumberContext _localctx = new SignedNumberContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_signedNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(179);
			match(NUMERIC_LITERAL);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\5\3\64\n\3\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\5\5>\n\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\3\t\3\t\3\t\7\tP\n\t\f\t\16"+
		"\tS\13\t\3\t\3\t\7\tW\n\t\f\t\16\tZ\13\t\3\n\3\n\3\n\5\n_\n\n\3\13\3\13"+
		"\3\f\3\f\3\f\7\ff\n\f\f\f\16\fi\13\f\3\r\3\r\3\r\3\r\3\r\5\rp\n\r\3\16"+
		"\6\16s\n\16\r\16\16\16t\3\17\5\17x\n\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\7\20\u0082\n\20\f\20\16\20\u0085\13\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u00aa\n\25\f\25\16\25\u00ad\13\25\3\25\3\25\3\26"+
		"\3\26\3\27\5\27\u00b4\n\27\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\3\3\2\32\33\2\u00af\2.\3\2\2\2\4\63\3\2\2"+
		"\2\68\3\2\2\2\b=\3\2\2\2\n?\3\2\2\2\fA\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2"+
		"\22[\3\2\2\2\24`\3\2\2\2\26b\3\2\2\2\30j\3\2\2\2\32r\3\2\2\2\34w\3\2\2"+
		"\2\36{\3\2\2\2 \u0088\3\2\2\2\"\u008c\3\2\2\2$\u008e\3\2\2\2&\u0093\3"+
		"\2\2\2(\u00a1\3\2\2\2*\u00b0\3\2\2\2,\u00b3\3\2\2\2./\5\6\4\2/\60\7\2"+
		"\2\3\60\3\3\2\2\2\61\64\5\b\5\2\62\64\5\n\6\2\63\61\3\2\2\2\63\62\3\2"+
		"\2\2\64\5\3\2\2\2\65\67\5\4\3\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\2"+
		"89\3\2\2\29\7\3\2\2\2:8\3\2\2\2;>\5\f\7\2<>\5$\23\2=;\3\2\2\2=<\3\2\2"+
		"\2>\t\3\2\2\2?@\5(\25\2@\13\3\2\2\2AB\7\5\2\2BC\7\n\2\2CD\5\16\b\2DE\7"+
		"\25\2\2EF\5\20\t\2FH\7\26\2\2GI\5 \21\2HG\3\2\2\2HI\3\2\2\2I\r\3\2\2\2"+
		"JK\5*\26\2K\17\3\2\2\2LQ\5\22\n\2MN\7\27\2\2NP\5\22\n\2OM\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2RX\3\2\2\2SQ\3\2\2\2TU\7\27\2\2UW\5\36\20\2"+
		"VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\21\3\2\2\2ZX\3\2\2\2[\\\5\24"+
		"\13\2\\^\5\30\r\2]_\5\34\17\2^]\3\2\2\2^_\3\2\2\2_\23\3\2\2\2`a\5*\26"+
		"\2a\25\3\2\2\2bg\5\24\13\2cd\7\27\2\2df\5\24\13\2ec\3\2\2\2fi\3\2\2\2"+
		"ge\3\2\2\2gh\3\2\2\2h\27\3\2\2\2ig\3\2\2\2jo\5\32\16\2kl\7\25\2\2lm\5"+
		",\27\2mn\7\26\2\2np\3\2\2\2ok\3\2\2\2op\3\2\2\2p\31\3\2\2\2qs\5*\26\2"+
		"rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\33\3\2\2\2vx\7\f\2\2wv\3\2\2"+
		"\2wx\3\2\2\2xy\3\2\2\2yz\7\r\2\2z\35\3\2\2\2{|\7\16\2\2|}\7\17\2\2}~\7"+
		"\25\2\2~\u0083\5\24\13\2\177\u0080\7\27\2\2\u0080\u0082\5\24\13\2\u0081"+
		"\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\26\2\2\u0087"+
		"\37\3\2\2\2\u0088\u0089\7\13\2\2\u0089\u008a\7\30\2\2\u008a\u008b\5\""+
		"\22\2\u008b!\3\2\2\2\u008c\u008d\5*\26\2\u008d#\3\2\2\2\u008e\u008f\7"+
		"\3\2\2\u008f\u0090\7\n\2\2\u0090\u0091\5\16\b\2\u0091\u0092\5&\24\2\u0092"+
		"%\3\2\2\2\u0093\u0094\7\4\2\2\u0094\u0095\7\7\2\2\u0095\u0096\5*\26\2"+
		"\u0096\u0097\7\b\2\2\u0097\u0098\7\17\2\2\u0098\u0099\7\25\2\2\u0099\u009a"+
		"\5\26\f\2\u009a\u009b\7\26\2\2\u009b\u009c\7\t\2\2\u009c\u009d\5\16\b"+
		"\2\u009d\u009e\7\25\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\7\26\2\2\u00a0"+
		"\'\3\2\2\2\u00a1\u00a2\7\20\2\2\u00a2\u00a3\7\21\2\2\u00a3\u00a4\5\16"+
		"\b\2\u00a4\u00a5\7\22\2\2\u00a5\u00a6\7\25\2\2\u00a6\u00ab\5,\27\2\u00a7"+
		"\u00a8\7\27\2\2\u00a8\u00aa\5,\27\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\7\26\2\2\u00af)\3\2\2\2\u00b0\u00b1\7+\2\2"+
		"\u00b1+\3\2\2\2\u00b2\u00b4\t\2\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7,\2\2\u00b6-\3\2\2\2\20\638=H"+
		"QX^gotw\u0083\u00ab\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		GT=36, GT_EQ=37, EQ=38, NOT_EQ1=39, NOT_EQ2=40, NEWLINE=41, IDENTIFIER=42, 
		NUMERIC_LITERAL=43, SPACES=44;
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
		"EQ", "NOT_EQ1", "NOT_EQ2", "NEWLINE", "IDENTIFIER", "NUMERIC_LITERAL", 
		"SPACES"
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
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			sqlDdlStatement();
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
		public List<TerminalNode> NEWLINE() { return getTokens(SqlParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SqlParser.NEWLINE, i);
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
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				sqlStatement();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(49);
					match(NEWLINE);
					setState(50);
					sqlStatement();
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ALTER) | (1L << K_ADD) | (1L << K_CREATE) | (1L << K_COLUMN) | (1L << K_CONSTRAIN) | (1L << K_FOREIGN) | (1L << K_REFERENCES) | (1L << K_TABLE) | (1L << K_ENGINE) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_PRIMARY) | (1L << K_KEY) | (1L << K_INSERT) | (1L << K_INTO) | (1L << K_VALUES) | (1L << SCOL) | (1L << DOT) | (1L << OPEN_PAR) | (1L << CLOSE_PAR) | (1L << COMMA) | (1L << ASSIGN) | (1L << STAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << PIPE2) | (1L << DIV) | (1L << MOD) | (1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE) | (1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ) | (1L << EQ) | (1L << NOT_EQ1) | (1L << NOT_EQ2) | (1L << NEWLINE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL) | (1L << SPACES))) != 0)) {
					{
					setState(56);
					matchWildcard();
					}
				}

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

	public static class SqlDdlStatementContext extends ParserRuleContext {
		public SqlCreateTableStatementContext sqlCreateTableStatement() {
			return getRuleContext(SqlCreateTableStatementContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			sqlCreateTableStatement();
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
			setState(63);
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
			setState(65);
			match(K_CREATE);
			setState(66);
			match(K_TABLE);
			setState(67);
			sqlTableName();
			setState(68);
			match(OPEN_PAR);
			setState(69);
			sqlColumnDefinitions();
			setState(70);
			match(CLOSE_PAR);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ENGINE) {
				{
				setState(71);
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
			setState(74);
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
			setState(76);
			sqlColumnDefinition();
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					sqlColumnDefinition();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(84);
				match(COMMA);
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(85);
					matchWildcard();
					}
					break;
				}
				}
				}
				setState(92);
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
			setState(93);
			sqlColumnName();
			setState(94);
			sqlColumnType();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_NOT || _la==K_NULL) {
				{
				setState(95);
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
			setState(98);
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
			setState(100);
			sqlColumnName();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(101);
				match(COMMA);
				setState(102);
				sqlColumnName();
				}
				}
				setState(107);
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
			setState(108);
			sqlColumnTypeName();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(109);
				match(OPEN_PAR);
				setState(110);
				signedNumber();
				setState(111);
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
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				identifier();
				}
				}
				setState(118); 
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(120);
				match(K_NOT);
				}
			}

			setState(123);
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
			setState(125);
			match(K_PRIMARY);
			setState(126);
			match(K_KEY);
			setState(127);
			match(OPEN_PAR);
			setState(128);
			sqlColumnName();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				sqlColumnName();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
			setState(138);
			match(K_ENGINE);
			setState(139);
			match(ASSIGN);
			setState(140);
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
			setState(142);
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
			setState(144);
			match(K_ALTER);
			setState(145);
			match(K_TABLE);
			setState(146);
			sqlTableName();
			setState(147);
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
			setState(149);
			match(K_ADD);
			setState(150);
			match(K_CONSTRAIN);
			setState(151);
			identifier();
			setState(152);
			match(K_FOREIGN);
			setState(153);
			match(K_KEY);
			setState(154);
			match(OPEN_PAR);
			setState(155);
			sqlColumnNames();
			setState(156);
			match(CLOSE_PAR);
			setState(157);
			match(K_REFERENCES);
			setState(158);
			sqlTableName();
			setState(159);
			match(OPEN_PAR);
			setState(160);
			sqlColumnNames();
			setState(161);
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
			setState(163);
			match(K_INSERT);
			setState(164);
			match(K_INTO);
			setState(165);
			sqlTableName();
			setState(166);
			match(K_VALUES);
			setState(167);
			match(OPEN_PAR);
			setState(168);
			signedNumber();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(169);
				match(COMMA);
				setState(170);
				signedNumber();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
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
			setState(178);
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
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(180);
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

			setState(183);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\4\5\4<\n\4\5\4>\n\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7K\n\7\3\b\3\b\3\t\3\t\3\t\7\tR\n\t\f"+
		"\t\16\tU\13\t\3\t\3\t\5\tY\n\t\7\t[\n\t\f\t\16\t^\13\t\3\n\3\n\3\n\5\n"+
		"c\n\n\3\13\3\13\3\f\3\f\3\f\7\fj\n\f\f\f\16\fm\13\f\3\r\3\r\3\r\3\r\3"+
		"\r\5\rt\n\r\3\16\6\16w\n\16\r\16\16\16x\3\17\5\17|\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0086\n\20\f\20\16\20\u0089\13\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00ae\n\25\f\25\16\25\u00b1\13\25"+
		"\3\25\3\25\3\26\3\26\3\27\5\27\u00b8\n\27\3\27\3\27\3\27\2\2\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\3\3\2\32\33\2\u00b4\2.\3\2"+
		"\2\2\4\60\3\2\2\2\6=\3\2\2\2\b?\3\2\2\2\nA\3\2\2\2\fC\3\2\2\2\16L\3\2"+
		"\2\2\20N\3\2\2\2\22_\3\2\2\2\24d\3\2\2\2\26f\3\2\2\2\30n\3\2\2\2\32v\3"+
		"\2\2\2\34{\3\2\2\2\36\177\3\2\2\2 \u008c\3\2\2\2\"\u0090\3\2\2\2$\u0092"+
		"\3\2\2\2&\u0097\3\2\2\2(\u00a5\3\2\2\2*\u00b4\3\2\2\2,\u00b7\3\2\2\2."+
		"/\5\6\4\2/\3\3\2\2\2\60\61\5\b\5\2\61\5\3\2\2\2\62\67\5\4\3\2\63\64\7"+
		"+\2\2\64\66\5\4\3\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2"+
		"\28>\3\2\2\29\67\3\2\2\2:<\13\2\2\2;:\3\2\2\2;<\3\2\2\2<>\3\2\2\2=\62"+
		"\3\2\2\2=;\3\2\2\2>\7\3\2\2\2?@\5\f\7\2@\t\3\2\2\2AB\5(\25\2B\13\3\2\2"+
		"\2CD\7\5\2\2DE\7\n\2\2EF\5\16\b\2FG\7\25\2\2GH\5\20\t\2HJ\7\26\2\2IK\5"+
		" \21\2JI\3\2\2\2JK\3\2\2\2K\r\3\2\2\2LM\5*\26\2M\17\3\2\2\2NS\5\22\n\2"+
		"OP\7\27\2\2PR\5\22\n\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\\\3\2"+
		"\2\2US\3\2\2\2VX\7\27\2\2WY\13\2\2\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZV\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\21\3\2\2\2^\\\3\2\2\2_`\5\24\13"+
		"\2`b\5\30\r\2ac\5\34\17\2ba\3\2\2\2bc\3\2\2\2c\23\3\2\2\2de\5*\26\2e\25"+
		"\3\2\2\2fk\5\24\13\2gh\7\27\2\2hj\5\24\13\2ig\3\2\2\2jm\3\2\2\2ki\3\2"+
		"\2\2kl\3\2\2\2l\27\3\2\2\2mk\3\2\2\2ns\5\32\16\2op\7\25\2\2pq\5,\27\2"+
		"qr\7\26\2\2rt\3\2\2\2so\3\2\2\2st\3\2\2\2t\31\3\2\2\2uw\5*\26\2vu\3\2"+
		"\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\33\3\2\2\2z|\7\f\2\2{z\3\2\2\2{|\3"+
		"\2\2\2|}\3\2\2\2}~\7\r\2\2~\35\3\2\2\2\177\u0080\7\16\2\2\u0080\u0081"+
		"\7\17\2\2\u0081\u0082\7\25\2\2\u0082\u0087\5\24\13\2\u0083\u0084\7\27"+
		"\2\2\u0084\u0086\5\24\13\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\7\26\2\2\u008b\37\3\2\2\2\u008c\u008d\7\13\2\2\u008d"+
		"\u008e\7\30\2\2\u008e\u008f\5\"\22\2\u008f!\3\2\2\2\u0090\u0091\5*\26"+
		"\2\u0091#\3\2\2\2\u0092\u0093\7\3\2\2\u0093\u0094\7\n\2\2\u0094\u0095"+
		"\5\16\b\2\u0095\u0096\5&\24\2\u0096%\3\2\2\2\u0097\u0098\7\4\2\2\u0098"+
		"\u0099\7\7\2\2\u0099\u009a\5*\26\2\u009a\u009b\7\b\2\2\u009b\u009c\7\17"+
		"\2\2\u009c\u009d\7\25\2\2\u009d\u009e\5\26\f\2\u009e\u009f\7\26\2\2\u009f"+
		"\u00a0\7\t\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\25\2\2\u00a2\u00a3\5"+
		"\26\f\2\u00a3\u00a4\7\26\2\2\u00a4\'\3\2\2\2\u00a5\u00a6\7\20\2\2\u00a6"+
		"\u00a7\7\21\2\2\u00a7\u00a8\5\16\b\2\u00a8\u00a9\7\22\2\2\u00a9\u00aa"+
		"\7\25\2\2\u00aa\u00af\5,\27\2\u00ab\u00ac\7\27\2\2\u00ac\u00ae\5,\27\2"+
		"\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\26\2\2"+
		"\u00b3)\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5+\3\2\2\2\u00b6\u00b8\t\2\2\2"+
		"\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba"+
		"\7-\2\2\u00ba-\3\2\2\2\21\67;=JSX\\bksx{\u0087\u00af\u00b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
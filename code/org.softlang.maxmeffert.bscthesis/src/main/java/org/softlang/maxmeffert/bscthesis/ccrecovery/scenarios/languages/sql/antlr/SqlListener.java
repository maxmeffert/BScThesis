package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
// Generated from Sql.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlParser}.
 */
public interface SqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlDocument}.
	 * @param ctx the parse tree
	 */
	void enterSqlDocument(SqlParser.SqlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlDocument}.
	 * @param ctx the parse tree
	 */
	void exitSqlDocument(SqlParser.SqlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlStatements}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatements(SqlParser.SqlStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlStatements}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatements(SqlParser.SqlStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlDdlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlDdlStatement(SqlParser.SqlDdlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlDdlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlDdlStatement(SqlParser.SqlDdlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlDmlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlDmlStatement(SqlParser.SqlDmlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlDmlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlDmlStatement(SqlParser.SqlDmlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlCreateTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlCreateTableStatement(SqlParser.SqlCreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlCreateTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlCreateTableStatement(SqlParser.SqlCreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlTableName}.
	 * @param ctx the parse tree
	 */
	void enterSqlTableName(SqlParser.SqlTableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlTableName}.
	 * @param ctx the parse tree
	 */
	void exitSqlTableName(SqlParser.SqlTableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnDefinitions(SqlParser.SqlColumnDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnDefinitions(SqlParser.SqlColumnDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnName}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnName(SqlParser.SqlColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnName}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnName(SqlParser.SqlColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnNames}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnNames(SqlParser.SqlColumnNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnNames}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnNames(SqlParser.SqlColumnNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnType}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnType(SqlParser.SqlColumnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnType}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnType(SqlParser.SqlColumnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnTypeName(SqlParser.SqlColumnTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnTypeName(SqlParser.SqlColumnTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnConstrain}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnConstrain(SqlParser.SqlColumnConstrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnConstrain}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnConstrain(SqlParser.SqlColumnConstrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlTableContstrain}.
	 * @param ctx the parse tree
	 */
	void enterSqlTableContstrain(SqlParser.SqlTableContstrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlTableContstrain}.
	 * @param ctx the parse tree
	 */
	void exitSqlTableContstrain(SqlParser.SqlTableContstrainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlTableEngine}.
	 * @param ctx the parse tree
	 */
	void enterSqlTableEngine(SqlParser.SqlTableEngineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlTableEngine}.
	 * @param ctx the parse tree
	 */
	void exitSqlTableEngine(SqlParser.SqlTableEngineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlTableEngineName}.
	 * @param ctx the parse tree
	 */
	void enterSqlTableEngineName(SqlParser.SqlTableEngineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlTableEngineName}.
	 * @param ctx the parse tree
	 */
	void exitSqlTableEngineName(SqlParser.SqlTableEngineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlAlterTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlAlterTableStatement(SqlParser.SqlAlterTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlAlterTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlAlterTableStatement(SqlParser.SqlAlterTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlAddTableConstraint}.
	 * @param ctx the parse tree
	 */
	void enterSqlAddTableConstraint(SqlParser.SqlAddTableConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlAddTableConstraint}.
	 * @param ctx the parse tree
	 */
	void exitSqlAddTableConstraint(SqlParser.SqlAddTableConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlInsertStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlInsertStatement(SqlParser.SqlInsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlInsertStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlInsertStatement(SqlParser.SqlInsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SqlParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SqlParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void enterSignedNumber(SqlParser.SignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void exitSignedNumber(SqlParser.SignedNumberContext ctx);
}
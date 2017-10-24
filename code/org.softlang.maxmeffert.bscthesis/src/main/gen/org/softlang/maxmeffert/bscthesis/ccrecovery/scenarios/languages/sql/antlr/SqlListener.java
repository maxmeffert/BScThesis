// Generated from /home/darjeeling/Documents/BScThesis/code/org.softlang.maxmeffert.bscthesis/src/main/java/org/softlang/maxmeffert/bscthesis/ccrecovery/scenarios/languages/sql/antlr/Sql.g4 by ANTLR 4.7
package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
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
	 * Enter a parse tree produced by {@link SqlParser#sqlColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx);
}
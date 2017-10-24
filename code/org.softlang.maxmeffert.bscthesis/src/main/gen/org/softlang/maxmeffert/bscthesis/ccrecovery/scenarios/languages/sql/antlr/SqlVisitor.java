// Generated from /home/darjeeling/Documents/BScThesis/code/org.softlang.maxmeffert.bscthesis/src/main/java/org/softlang/maxmeffert/bscthesis/ccrecovery/scenarios/languages/sql/antlr/Sql.g4 by ANTLR 4.7
package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlDocument(SqlParser.SqlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlDdlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlDdlStatement(SqlParser.SqlDdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlCreateTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlCreateTableStatement(SqlParser.SqlCreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx);
}
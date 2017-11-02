package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;

import java.util.Stack;

public class SqlFragmentFactory extends BaseFragmentFactory {

    public SqlDocumentFragment newSqlDocumentFagment(SqlParser.SqlDocumentContext sqlDocumentContext, Stack<SqlCreateTableFragment> sqlCreateTableFragments) {
        SqlDocumentFragment sqlDocumentFragment = initialize(new SqlDocumentFragment(), sqlDocumentContext);
        popEach(sqlCreateTableFragments, sqlDocumentFragment::addSqlCreateTableFragment);
        return sqlDocumentFragment;
    }

    public SqlCreateTableFragment newSqlCreateTableFragment(SqlParser.SqlCreateTableStatementContext sqlCreateTableStatementContext, Stack<SqlColumnFragment> sqlColumnFragments) {
        SqlCreateTableFragment sqlCreateTableFragment = initialize(new SqlCreateTableFragment(), sqlCreateTableStatementContext);
        sqlCreateTableFragment.setTableName(textOf(sqlCreateTableStatementContext.sqlTableName()));
        popEach(sqlColumnFragments, sqlCreateTableFragment::addSqlColumnFragment);
        return sqlCreateTableFragment;
    }

    public SqlColumnFragment newSqlColumnFragment(SqlParser.SqlColumnDefinitionContext sqlColumnDefinitionContext) {
        SqlColumnFragment sqlColumnFragment = initialize(new SqlColumnFragment(), sqlColumnDefinitionContext);
        sqlColumnFragment.setColumnName(textOf(sqlColumnDefinitionContext.sqlColumnName()));
        return sqlColumnFragment;
    }

}

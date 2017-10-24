package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.BaseFragmentASTFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;

public class SqlFragmentFactory extends BaseFragmentASTFactory {

    public SqlCreateTableFragment newSqlCreateTableFragment(SqlParser.SqlCreateTableStatementContext sqlCreateTableStatementContext) {
        SqlCreateTableFragment sqlCreateTableFragment = initialize(new SqlCreateTableFragment(), sqlCreateTableStatementContext);
        sqlCreateTableFragment.setTableName(textOf(sqlCreateTableStatementContext.sqlTableName()));
        return sqlCreateTableFragment;
    }

}

package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlBaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;

import java.util.Stack;

public class SqlFragmentBuildingListener extends SqlBaseListener implements IFragmentASTBuildingListener {

    private final SqlFragmentFactory sqlFragmentFactory = new SqlFragmentFactory();

    private final Stack<SqlCreateTableFragment> sqlCreateTableFragments = new Stack<>();

    private SqlDocumentFragment sqlDocumentFragment;

    @Override
    public void exitSqlCreateTableStatement(SqlParser.SqlCreateTableStatementContext ctx) {
        sqlCreateTableFragments.push(sqlFragmentFactory.newSqlCreateTableFragment(ctx));
        System.out.println(sqlCreateTableFragments.peek().getTableName());
    }

    @Override
    public void exitSqlDocument(SqlParser.SqlDocumentContext ctx) {
        sqlDocumentFragment = new SqlDocumentFragment();
        while (!sqlCreateTableFragments.isEmpty()) {
            sqlDocumentFragment.addSqlCreateTableFragment(sqlCreateTableFragments.pop());
        }
    }

    @Override
    public IFragmentAST getFragmentAST() {
        return sqlDocumentFragment;
    }
}

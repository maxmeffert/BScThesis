package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlBaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlParser;

import java.util.Stack;

public class SqlFragmentBuildingListener extends SqlBaseListener implements IFragmentASTBuildingListener {

    private final SqlFragmentFactory sqlFragmentFactory = new SqlFragmentFactory();

    private final Stack<SqlCreateTableFragment> sqlCreateTableFragments = new Stack<>();
    private final Stack<SqlColumnFragment> sqlColumnFragments = new Stack<>();

    private SqlDocumentFragment sqlDocumentFragment;

    @Override
    public void exitSqlCreateTableStatement(SqlParser.SqlCreateTableStatementContext ctx) {
        sqlCreateTableFragments.push(sqlFragmentFactory.newSqlCreateTableFragment(ctx, sqlColumnFragments));

    }

    @Override
    public void exitSqlColumnDefinition(SqlParser.SqlColumnDefinitionContext ctx) {
        sqlColumnFragments.push(sqlFragmentFactory.newSqlColumnFragment(ctx));
    }

    @Override
    public void exitSqlDocument(SqlParser.SqlDocumentContext ctx) {
        sqlDocumentFragment = sqlFragmentFactory.newSqlDocumentFagment(ctx, sqlCreateTableFragments);
    }

    @Override
    public IFragmentAST getFragmentAST() {
        System.out.println(sqlDocumentFragment);
        sqlDocumentFragment.getSqlCreateTableFragments().forEach((ct) -> {
            System.out.println(ct.getTableName());
            ct.getSqlColumnFragments().forEach((col) -> {
                System.out.println(col.getColumnName());
            });
        });
        return sqlDocumentFragment;
    }
}

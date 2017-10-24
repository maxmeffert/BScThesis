package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.antlr.SqlBaseListener;

public class SqlFragmentBuildingListener extends SqlBaseListener implements IFragmentASTBuildingListener {

    private final SqlFragmentFactory sqlFragmentFactory = new SqlFragmentFactory();

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println(ctx.getClass());
    }


    @Override
    public IFragmentAST getFragmentAST() {
        return new SqlDocumentFragment();
    }
}

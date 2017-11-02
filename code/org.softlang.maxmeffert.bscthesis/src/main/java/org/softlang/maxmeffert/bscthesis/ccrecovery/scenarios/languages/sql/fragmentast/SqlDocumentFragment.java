package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import com.google.common.collect.Lists;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentAST;

import java.util.List;

public class SqlDocumentFragment extends BaseFragmentAST {

    private final List<SqlCreateTableFragment> sqlCreateTableFragments = Lists.newLinkedList();

    public List<SqlCreateTableFragment> getSqlCreateTableFragments() {
        return sqlCreateTableFragments;
    }

    public void addSqlCreateTableFragment(SqlCreateTableFragment sqlCreateTableFragment) {
        sqlCreateTableFragments.add(sqlCreateTableFragment);
        addChild(sqlCreateTableFragment);
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import com.google.common.collect.Lists;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.BaseFragmentAST;

import java.util.List;

public class SqlCreateTableFragment extends BaseFragmentAST {

    private String tableName = "";
    private List<SqlColumnFragment> sqlColumnFragments = Lists.newLinkedList();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<SqlColumnFragment> getSqlColumnFragments() {
        return sqlColumnFragments;
    }

    public void addSqlColumnFragment(SqlColumnFragment sqlColumnFragment) {
        sqlColumnFragments.add(sqlColumnFragment);
        addChild(sqlColumnFragment);
    }
}

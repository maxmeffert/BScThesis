package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.BaseFragmentAST;

public class SqlCreateTableFragment extends BaseFragmentAST {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

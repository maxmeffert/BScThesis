package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.sql.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentAST;

public class SqlColumnFragment extends BaseFragmentAST {

    private String columnName = "";

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}

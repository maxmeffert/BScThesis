package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

public abstract class TypedJavaFragmentAST extends ModifiedJavaFragmentAST {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

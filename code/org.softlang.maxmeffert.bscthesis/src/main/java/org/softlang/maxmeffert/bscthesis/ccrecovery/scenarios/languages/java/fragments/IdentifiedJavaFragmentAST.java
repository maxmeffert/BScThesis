package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

public abstract class IdentifiedJavaFragmentAST extends JavaFragmentAST {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}

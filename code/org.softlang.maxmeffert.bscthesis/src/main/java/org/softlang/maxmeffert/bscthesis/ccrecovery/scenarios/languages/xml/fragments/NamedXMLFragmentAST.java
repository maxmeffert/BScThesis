package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

public abstract class NamedXMLFragmentAST extends XMLFragmentAST {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

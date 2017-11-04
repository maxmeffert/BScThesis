package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

public abstract class NamedXmlFragment extends XmlFragment {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

public abstract class NamedXMLFragment extends XMLFragment {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
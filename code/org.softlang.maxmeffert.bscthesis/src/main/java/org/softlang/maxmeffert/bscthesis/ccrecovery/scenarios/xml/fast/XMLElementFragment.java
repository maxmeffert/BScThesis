package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import java.util.LinkedList;
import java.util.List;

public class XMLElementFragment extends XMLFragment {

    private String name;
    private List<XMLElementFragment> elements = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XMLElementFragment> getElements() {
        return elements;
    }

    public void addElement(XMLElementFragment element) {
        elements.add(element);
        addChild(element);
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import java.util.LinkedList;
import java.util.List;

public class XMLDocumentFragment extends XMLFragment {
    private List<XMLElementFragment> elements = new LinkedList<>();

    public List<XMLElementFragment> getElements() {
        return elements;
    }

    public void addElement(XMLElementFragment element) {
        elements.add(element);
        addChild(element);
    }
}

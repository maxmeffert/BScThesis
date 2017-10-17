package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import java.util.List;

public class XMLFragmentFactory {

    public XMLDocumentFragment newXMLDocumentFragment(String text, List<XMLElementFragment> elements) {
        return new XMLDocumentFragment(text, elements);
    }

    public XMLElementFragment newXMLElementFragment(String name, String text, List<XMLElementFragment> elements) {
        return new XMLElementFragment(name, text, elements);
    }
}

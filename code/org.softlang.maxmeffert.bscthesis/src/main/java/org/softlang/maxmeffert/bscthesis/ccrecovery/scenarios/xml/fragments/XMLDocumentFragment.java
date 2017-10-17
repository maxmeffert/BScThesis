package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments;

import java.util.LinkedList;
import java.util.List;

public class XMLDocumentFragment extends XMLFragment {
    private List<XMLElementFragment> xmlElementFragments = new LinkedList<>();

    public List<XMLElementFragment> getXmlElementFragments() {
        return xmlElementFragments;
    }

    public void addXMLElementFragment(XMLElementFragment xmlElementFragment) {
        xmlElementFragments.add(xmlElementFragment);
        addChild(xmlElementFragment);
    }
}

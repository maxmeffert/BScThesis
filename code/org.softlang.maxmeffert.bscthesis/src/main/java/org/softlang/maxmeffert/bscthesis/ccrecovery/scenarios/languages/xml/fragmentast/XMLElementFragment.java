package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import java.util.LinkedList;
import java.util.List;

public class XMLElementFragment extends NamedXMLFragment {

    private String content;
    private List<XMLElementFragment> xmlElementFragments = new LinkedList<>();
    private List<XMLAttributeFragment> xmlAttributeFragments = new LinkedList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<XMLElementFragment> getXmlElementFragments() {
        return xmlElementFragments;
    }

    public void addXMLElementFragment(XMLElementFragment xmlElementFragment) {
        xmlElementFragments.add(xmlElementFragment);
        addChild(xmlElementFragment);
    }

    public List<XMLAttributeFragment> getXmlAttributeFragments() {
        return xmlAttributeFragments;
    }

    public void addXMLAttributeFragment(XMLAttributeFragment xmlAttributeFragment) {
        xmlAttributeFragments.add(xmlAttributeFragment);
        addChild(xmlAttributeFragment);
    }
}

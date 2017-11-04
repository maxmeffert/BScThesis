package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XmlElementFragment extends NamedXmlFragment {

    private String content;
    private List<XmlElementFragment> xmlElementFragments = new LinkedList<>();
    private List<XmlAttributeFragment> xmlAttributeFragments = new LinkedList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<XmlElementFragment> getXmlElementFragments() {
        return xmlElementFragments;
    }

    public void addXMLElementFragment(XmlElementFragment xmlElementFragment) {
        xmlElementFragments.add(xmlElementFragment);
        addChild(xmlElementFragment);
    }

    public List<XmlAttributeFragment> getXmlAttributeFragments() {
        return xmlAttributeFragments;
    }

    public void addXMLAttributeFragment(XmlAttributeFragment xmlAttributeFragment) {
        xmlAttributeFragments.add(xmlAttributeFragment);
        addChild(xmlAttributeFragment);
    }
}

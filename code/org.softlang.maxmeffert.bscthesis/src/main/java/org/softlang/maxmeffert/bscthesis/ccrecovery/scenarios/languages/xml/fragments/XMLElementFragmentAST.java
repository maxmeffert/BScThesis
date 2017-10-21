package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

import java.util.LinkedList;
import java.util.List;

public class XMLElementFragmentAST extends NamedXMLFragmentAST {

    private String content;
    private List<XMLElementFragmentAST> xmlElementFragments = new LinkedList<>();
    private List<XMLAttributeFragmentAST> xmlAttributeFragments = new LinkedList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<XMLElementFragmentAST> getXmlElementFragments() {
        return xmlElementFragments;
    }

    public void addXMLElementFragment(XMLElementFragmentAST xmlElementFragment) {
        xmlElementFragments.add(xmlElementFragment);
        addChild(xmlElementFragment);
    }

    public List<XMLAttributeFragmentAST> getXmlAttributeFragments() {
        return xmlAttributeFragments;
    }

    public void addXMLAttributeFragment(XMLAttributeFragmentAST xmlAttributeFragment) {
        xmlAttributeFragments.add(xmlAttributeFragment);
        addChild(xmlAttributeFragment);
    }
}

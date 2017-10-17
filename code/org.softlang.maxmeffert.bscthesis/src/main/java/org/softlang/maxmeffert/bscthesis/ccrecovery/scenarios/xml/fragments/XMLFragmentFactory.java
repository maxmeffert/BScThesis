package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;

import java.util.Stack;

public class XMLFragmentFactory extends BaseFragmentFactory {

    public XMLDocumentFragment newXMLDocumentFragment(XMLParser.DocumentContext documentContext) {
        XMLDocumentFragment xmlDocumentFragment = initialize(new XMLDocumentFragment(), documentContext);
        return xmlDocumentFragment;
    }

    public XMLDocumentFragment newXMLDocumentFragment(XMLParser.DocumentContext documentContext, Stack<XMLElementFragment> xmlElementFragments) {
        XMLDocumentFragment xmlDocumentFragment = newXMLDocumentFragment(documentContext);
        while (!xmlElementFragments.isEmpty()) {
            xmlDocumentFragment.addElement(xmlElementFragments.pop());
        }
        return xmlDocumentFragment;
    }

    public XMLElementFragment newXMLElementFragment(XMLParser.ElementContext elementContext) {
        XMLElementFragment xmlElementFragment = initialize(new XMLElementFragment(), elementContext);
        xmlElementFragment.setName(elementContext.Name(0).getText());
        return xmlElementFragment;
    }
    public XMLElementFragment newXMLElementFragment(XMLParser.ElementContext elementContext, Stack<XMLElementFragment> xmlElementFragments) {
        XMLElementFragment xmlElementFragment = newXMLElementFragment(elementContext);
        while (!xmlElementFragments.isEmpty()) {
            xmlElementFragment.addElement(xmlElementFragments.pop());
        }
        return xmlElementFragment;
    }
}

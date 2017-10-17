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
            xmlDocumentFragment.addXMLElementFragment(xmlElementFragments.pop());
        }
        return xmlDocumentFragment;
    }

    public XMLElementFragment newXMLElementFragment(XMLParser.ElementContext elementContext) {
        XMLElementFragment xmlElementFragment = initialize(new XMLElementFragment(), elementContext);
        xmlElementFragment.setName(elementContext.Name(0).getText());
        if (elementContext.content() != null) {
            xmlElementFragment.setContent(elementContext.content().getText());
        }
        return xmlElementFragment;
    }
    public XMLElementFragment newXMLElementFragment(XMLParser.ElementContext elementContext, Stack<XMLElementFragment> xmlElementFragments, Stack<XMLAttributeFragment> xmlAttributeFragments) {
        XMLElementFragment xmlElementFragment = newXMLElementFragment(elementContext);
        while (!xmlElementFragments.isEmpty()) {
            xmlElementFragment.addXMLElementFragment(xmlElementFragments.pop());
        }
        while (!xmlAttributeFragments.isEmpty()) {
            xmlElementFragment.addXMLAttributeFragment(xmlAttributeFragments.pop());
        }
        return xmlElementFragment;
    }

    public XMLAttributeFragment newXMLAttributeFragment(XMLParser.AttributeContext attributeContext) {
        XMLAttributeFragment xmlAttributeFragment = initialize(new XMLAttributeFragment(), attributeContext);
        xmlAttributeFragment.setName(attributeContext.Name().getText());
        xmlAttributeFragment.setValue(attributeContext.STRING().getText());
        return xmlAttributeFragment;
    }
}

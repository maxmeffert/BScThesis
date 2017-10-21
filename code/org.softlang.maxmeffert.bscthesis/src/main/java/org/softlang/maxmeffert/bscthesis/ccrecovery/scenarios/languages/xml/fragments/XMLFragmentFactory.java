package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;

public class XMLFragmentFactory extends BaseFragmentFactory {

    public XMLDocumentFragment newXMLDocumentFragment(XMLParser.DocumentContext documentContext) {
        XMLDocumentFragment xmlDocumentFragment = initialize(new XMLDocumentFragment(), documentContext);
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

    public XMLAttributeFragment newXMLAttributeFragment(XMLParser.AttributeContext attributeContext) {
        XMLAttributeFragment xmlAttributeFragment = initialize(new XMLAttributeFragment(), attributeContext);
        xmlAttributeFragment.setName(attributeContext.Name().getText());
        xmlAttributeFragment.setValue(attributeContext.STRING().getText());
        return xmlAttributeFragment;
    }
}

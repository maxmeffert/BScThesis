package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.BaseFragmentASTFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;

public class XMLFragmentASTFactory extends BaseFragmentASTFactory {

    public XMLDocumentFragmentAST newXMLDocumentFragment(XMLParser.DocumentContext documentContext) {
        XMLDocumentFragmentAST xmlDocumentFragment = initialize(new XMLDocumentFragmentAST(), documentContext);
        return xmlDocumentFragment;
    }

    public XMLElementFragmentAST newXMLElementFragment(XMLParser.ElementContext elementContext) {
        XMLElementFragmentAST xmlElementFragment = initialize(new XMLElementFragmentAST(), elementContext);
        xmlElementFragment.setName(elementContext.Name(0).getText());
        if (elementContext.content() != null) {
            xmlElementFragment.setContent(elementContext.content().getText());
        }
        return xmlElementFragment;
    }

    public XMLAttributeFragmentAST newXMLAttributeFragment(XMLParser.AttributeContext attributeContext) {
        XMLAttributeFragmentAST xmlAttributeFragment = initialize(new XMLAttributeFragmentAST(), attributeContext);
        xmlAttributeFragment.setName(attributeContext.Name().getText());
        xmlAttributeFragment.setValue(attributeContext.STRING().getText());
        return xmlAttributeFragment;
    }
}

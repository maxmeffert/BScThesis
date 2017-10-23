package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.BaseFragmentASTFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;

public class XMLFragmentASTFactory extends BaseFragmentASTFactory {

    private static final String DoubleQuote = "\"";
    private static final String SingleQuote = "'";

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

    private String removeQuotes(String string) {
        if (string.startsWith(DoubleQuote) && string.endsWith(DoubleQuote)) {
            return string.substring(DoubleQuote.length(), string.length()-DoubleQuote.length());
        }
        if (string.startsWith(SingleQuote) && string.endsWith(SingleQuote)) {
            return string.substring(SingleQuote.length(), string.length()-SingleQuote.length());
        }
        return string;
    }

    public XMLAttributeFragmentAST newXMLAttributeFragment(XMLParser.AttributeContext attributeContext) {
        XMLAttributeFragmentAST xmlAttributeFragment = initialize(new XMLAttributeFragmentAST(), attributeContext);
        xmlAttributeFragment.setName(attributeContext.Name().getText());
        xmlAttributeFragment.setValue(removeQuotes(attributeContext.STRING().getText()));
        return xmlAttributeFragment;
    }
}

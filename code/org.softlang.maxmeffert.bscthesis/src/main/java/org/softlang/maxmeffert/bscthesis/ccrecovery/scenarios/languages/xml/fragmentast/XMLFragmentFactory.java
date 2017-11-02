package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

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
        xmlAttributeFragment.setValue(StringUtils.removeQuotes(attributeContext.STRING().getText()));
        return xmlAttributeFragment;
    }
}

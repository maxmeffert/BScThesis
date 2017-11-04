package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class XmlFragmentFactory extends BaseFragmentFactory {

    public XmlDocumentFragment newXMLDocumentFragment(XMLParser.DocumentContext documentContext) {
        XmlDocumentFragment xmlDocumentFragment = initialize(new XmlDocumentFragment(), documentContext);
        return xmlDocumentFragment;
    }

    public XmlElementFragment newXMLElementFragment(XMLParser.ElementContext elementContext) {
        XmlElementFragment xmlElementFragment = initialize(new XmlElementFragment(), elementContext);
        xmlElementFragment.setName(elementContext.Name(0).getText());
        if (elementContext.content() != null) {
            xmlElementFragment.setContent(elementContext.content().getText());
        }
        return xmlElementFragment;
    }

    public XmlAttributeFragment newXMLAttributeFragment(XMLParser.AttributeContext attributeContext) {
        XmlAttributeFragment xmlAttributeFragment = initialize(new XmlAttributeFragment(), attributeContext);
        xmlAttributeFragment.setName(attributeContext.Name().getText());
        xmlAttributeFragment.setValue(StringUtils.removeQuotes(attributeContext.STRING().getText()));
        return xmlAttributeFragment;
    }
}

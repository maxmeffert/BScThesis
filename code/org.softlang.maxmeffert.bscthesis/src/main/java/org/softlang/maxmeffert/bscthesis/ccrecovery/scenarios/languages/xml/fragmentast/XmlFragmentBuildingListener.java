package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParserBaseListener;

import java.util.Stack;

public class XmlFragmentBuildingListener extends XMLParserBaseListener implements IFragmentBuildingListener {

    private final XmlFragmentFactory xmlFragmentFactory = new XmlFragmentFactory();

    private Stack<XmlElementFragment> xmlElementFragments = new Stack<>();
    private Stack<XmlDocumentFragment> xmlDocumentFragments = new Stack<>();

    @Override
    public void exitAttribute(XMLParser.AttributeContext ctx) {
        if (!xmlElementFragments.isEmpty()) {
            xmlElementFragments.peek().addXMLAttributeFragment(xmlFragmentFactory.newXMLAttributeFragment(ctx));
        }
    }

    @Override
    public void enterElement(XMLParser.ElementContext ctx) {
        XmlElementFragment xmlElementFragment = xmlFragmentFactory.newXMLElementFragment(ctx);
        if (!xmlElementFragments.isEmpty()) {
            xmlElementFragments.peek().addXMLElementFragment(xmlElementFragment);
        }
        xmlElementFragments.push(xmlElementFragment);
    }

    @Override
    public void exitElement(XMLParser.ElementContext ctx) {

        if (xmlElementFragments.size() > 1) {
            xmlElementFragments.pop();
        }
    }

    @Override
    public void exitDocument(XMLParser.DocumentContext ctx) {
        XmlDocumentFragment xmlDocumentFragment = xmlFragmentFactory.newXMLDocumentFragment(ctx);
        xmlDocumentFragment.setXmlElementFragment(xmlElementFragments.pop());
        xmlDocumentFragments.push(xmlDocumentFragment);
    }

    @Override
    public void exitProlog(XMLParser.PrologContext ctx) {
//        xmlAttributeFragments.clear();
    }

    @Override
    public IFragment getFragment() {
        return xmlDocumentFragments.peek();
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.antlr.XMLParserBaseListener;

import java.util.Stack;

public class XMLFragmentASTBuildingListener extends XMLParserBaseListener implements IFragmentASTBuildingListener {

    private final XMLFragmentASTFactory xmlFragmentFactory = new XMLFragmentASTFactory();

    private Stack<XMLElementFragmentAST> xmlElementFragments = new Stack<>();
    private Stack<XMLDocumentFragmentAST> xmlDocumentFragments = new Stack<>();

    @Override
    public void exitAttribute(XMLParser.AttributeContext ctx) {
        if (!xmlElementFragments.isEmpty()) {
            xmlElementFragments.peek().addXMLAttributeFragment(xmlFragmentFactory.newXMLAttributeFragment(ctx));
        }
    }

    @Override
    public void enterElement(XMLParser.ElementContext ctx) {
        XMLElementFragmentAST xmlElementFragment = xmlFragmentFactory.newXMLElementFragment(ctx);
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
        XMLDocumentFragmentAST xmlDocumentFragment = xmlFragmentFactory.newXMLDocumentFragment(ctx);
        xmlDocumentFragment.setXmlElementFragment(xmlElementFragments.pop());
        xmlDocumentFragments.push(xmlDocumentFragment);
    }

    @Override
    public void exitProlog(XMLParser.PrologContext ctx) {
//        xmlAttributeFragments.clear();
    }

    @Override
    public IFragmentAST getFragmentAST() {
        return xmlDocumentFragments.peek();
    }
}

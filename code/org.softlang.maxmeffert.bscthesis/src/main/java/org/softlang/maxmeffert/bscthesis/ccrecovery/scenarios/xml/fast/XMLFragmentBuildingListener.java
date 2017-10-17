package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParserBaseListener;

import java.util.Stack;

public class XMLFragmentBuildingListener extends XMLParserBaseListener implements IFragmentBuildingListener {

    private final XMLFragmentFactory xmlFragmentFactory = new XMLFragmentFactory();

    private Stack<XMLElementFragment> xmlElementFragments = new Stack<>();
    private Stack<XMLDocumentFragment> xmlDocumentFragments = new Stack<>();

    @Override
    public void exitElement(XMLParser.ElementContext ctx) {
        xmlElementFragments.push(xmlFragmentFactory.newXMLElementFragment(ctx, xmlElementFragments));
    }

    @Override
    public void exitDocument(XMLParser.DocumentContext ctx) {
        xmlDocumentFragments.push(xmlFragmentFactory.newXMLDocumentFragment(ctx, xmlElementFragments));
    }

    @Override
    public IFragment getFragment() {
        return xmlDocumentFragments.peek();
    }
}

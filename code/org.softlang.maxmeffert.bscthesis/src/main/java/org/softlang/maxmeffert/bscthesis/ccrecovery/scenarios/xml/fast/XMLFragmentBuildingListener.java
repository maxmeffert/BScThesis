package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.antlr.XMLParserBaseListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class XMLFragmentBuildingListener extends XMLParserBaseListener implements IFragmentBuildingListener {

    private final XMLFragmentFactory xmlFragmentFactory = new XMLFragmentFactory();

    private Stack<XMLElementFragment> xmlElementFragments = new Stack<>();
    private Stack<XMLDocumentFragment> xmlDocumentFragments = new Stack<>();

    private <T> List<T> popAllInto(Stack<T> stack, List<T> list) {
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private String textof(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b));
    }

    @Override
    public void exitElement(XMLParser.ElementContext ctx) {
        super.exitElement(ctx);
        String name = ctx.Name(0).getText();
        String text = textof(ctx);
        XMLElementFragment xmlElementFragment = xmlFragmentFactory.newXMLElementFragment();
        xmlElementFragment.setName(ctx.Name(0).toString());
        xmlElementFragment.setText(textof(ctx));
        while (!xmlElementFragments.isEmpty()) {
            xmlElementFragment.addElement(xmlElementFragments.pop());
        }
        xmlElementFragments.push(xmlElementFragment);
    }

    @Override
    public void exitDocument(XMLParser.DocumentContext ctx) {
        super.exitDocument(ctx);
        String text = textof(ctx);
        XMLDocumentFragment xmlDocumentFragment = xmlFragmentFactory.newXMLDocumentFragment();
        xmlDocumentFragment.setText(textof(ctx));
        while(!xmlElementFragments.isEmpty()) {
            xmlDocumentFragment.addElement(xmlElementFragments.pop());
        }
        xmlDocumentFragments.push(xmlDocumentFragment);
    }

    @Override
    public IFragment getFragment() {
        return xmlDocumentFragments.peek();
    }
}

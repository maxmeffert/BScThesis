package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FragmentKBBuildingParseTreeListener implements IFragmentKBBuildingParseTreeListener {

    private final IFragmentFactory fragmentFactory;

    public FragmentKBBuildingParseTreeListener(IFragmentFactory fragmentFactory) {
        this.fragmentFactory = fragmentFactory;
    }

    @Override
    public IFragmentKB getFragmentKB() {
        return null;
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}

package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTree;

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
    public void enter(ISimpleParseTree parseTree) {

    }

    @Override
    public void exit(ISimpleParseTree parseTree) {

    }
}

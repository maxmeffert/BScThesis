package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.tree.*;
import org.softlang.maxmeffert.bscthesis.antlr.IParseTreeWalkerFactory;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final IParseTreeWalkerFactory parseTreeWalkerFactory;
    private final IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;

    public FragmentKBFactory(IParseTreeWalkerFactory parseTreeWalkerFactory, IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory) {
        this.parseTreeWalkerFactory = parseTreeWalkerFactory;
        this.fragmentKBBuildingParseTreeListenerFactory = fragmentKBBuildingParseTreeListenerFactory;
    }

    @Override
    public IFragmentKB newFragmentKB(ParseTree parseTree) {
        ParseTreeWalker parseTreeWalker = parseTreeWalkerFactory.newParseTreeWalker();
        IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener = fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener();
        parseTreeWalker.walk(fragmentKBBuildingParseTreeListener, parseTree);
        return fragmentKBBuildingParseTreeListener.getFragmentKB();
    }
}

package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.tree.*;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeWalkerFactory;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final ISimpleParseTreeWalkerFactory parseTreeWalkerFactory;
    private final IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;

    public FragmentKBFactory(ISimpleParseTreeWalkerFactory parseTreeWalkerFactory, IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory) {
        this.parseTreeWalkerFactory = parseTreeWalkerFactory;
        this.fragmentKBBuildingParseTreeListenerFactory = fragmentKBBuildingParseTreeListenerFactory;
    }

    @Override
    public IFragmentKB newFragmentKB(ParseTree parseTree) {
//        SimpleParseTreeWalker parseTreeWalker = parseTreeWalkerFactory.newParseTreeWalker();
//        IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener = fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener();
//        parseTreeWalker.walk(fragmentKBBuildingParseTreeListener, parseTree);
//        return fragmentKBBuildingParseTreeListener.getFragmentKB();
        return null;
    }
}

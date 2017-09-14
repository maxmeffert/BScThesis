package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTree;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeWalker;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeWalkerFactory;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final ISimpleParseTreeWalkerFactory parseTreeWalkerFactory;
    private final IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;

    public FragmentKBFactory(ISimpleParseTreeWalkerFactory parseTreeWalkerFactory, IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory) {
        this.parseTreeWalkerFactory = parseTreeWalkerFactory;
        this.fragmentKBBuildingParseTreeListenerFactory = fragmentKBBuildingParseTreeListenerFactory;
    }

    @Override
    public IFragmentKB newFragmentKB(ISimpleParseTree simpleParseTree) {
        ISimpleParseTreeWalker parseTreeWalker = parseTreeWalkerFactory.newParseTreeWalker();
        IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener = fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener();
        parseTreeWalker.walk(simpleParseTree, fragmentKBBuildingParseTreeListener);
        return fragmentKBBuildingParseTreeListener.getFragmentKB();
    }
}

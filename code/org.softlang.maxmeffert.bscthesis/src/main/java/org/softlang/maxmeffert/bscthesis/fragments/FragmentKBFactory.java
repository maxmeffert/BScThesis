package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalker;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerFactory;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final ITreeWalkerFactory parseTreeWalkerFactory;
    private final IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;

    public FragmentKBFactory(ITreeWalkerFactory parseTreeWalkerFactory, IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory) {
        this.parseTreeWalkerFactory = parseTreeWalkerFactory;
        this.fragmentKBBuildingParseTreeListenerFactory = fragmentKBBuildingParseTreeListenerFactory;
    }

    @Override
    public IFragmentKB newFragmentKB(ITree<ITextSource> simpleParseTree) {
        ITreeWalker<ITextSource> parseTreeWalker = parseTreeWalkerFactory.newTreeWalker();
        IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener = fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener();
        parseTreeWalker.walk(simpleParseTree, fragmentKBBuildingParseTreeListener);
        return fragmentKBBuildingParseTreeListener.getFragmentKB();
    }
}

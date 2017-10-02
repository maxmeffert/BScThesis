package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public class FragmentKBFactory implements IFragmentKBFactory {
    @Override
    public IFragmentKB newFragmentKB(ITree<ITextSource> simpleParseTree) {
        return null;
    }

//    private final ITreeWalkerFactory parseTreeWalkerFactory;
//    private final IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;
//
//    public FragmentKBFactory(ITreeWalkerFactory parseTreeWalkerFactory, IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory) {
//        this.parseTreeWalkerFactory = parseTreeWalkerFactory;
//        this.fragmentKBBuildingParseTreeListenerFactory = fragmentKBBuildingParseTreeListenerFactory;
//    }
//
//    @Override
//    public IFragmentKB newFragmentKB(ITree<ITextSource> simpleParseTree) {
//        ITreeWalker<ITextSource> parseTreeWalker = parseTreeWalkerFactory.newTreeWalker();
//        IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener = fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener();
//        parseTreeWalker.walk(simpleParseTree, fragmentKBBuildingParseTreeListener);
//        return fragmentKBBuildingParseTreeListener.getFragmentKB();
//    }
}

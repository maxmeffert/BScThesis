package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ITree<ITextSource> simpleParseTree);

}

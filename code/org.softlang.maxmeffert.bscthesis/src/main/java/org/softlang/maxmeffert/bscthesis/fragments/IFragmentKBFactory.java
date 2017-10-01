package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.graphs.ITree;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ITree<ITextSource> simpleParseTree);

}

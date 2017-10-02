package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ITree<ITextSource> parseTree);

}

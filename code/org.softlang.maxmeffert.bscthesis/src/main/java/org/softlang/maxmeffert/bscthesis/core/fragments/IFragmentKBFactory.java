package org.softlang.maxmeffert.bscthesis.core.fragments;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ITree<ITextSource> parseTree);

}

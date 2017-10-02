package org.softlang.maxmeffert.bscthesis.core.fragments;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

public interface IFragment extends Comparable<IFragment> {

    ITree<ITextSource> getParseTree();
    String getText();

}

package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface IFragment extends Comparable<IFragment> {

    ITree<ITextSource> getParseTree();
    String getText();

}

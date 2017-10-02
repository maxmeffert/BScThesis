package org.softlang.maxmeffert.bscthesis.core.fragments;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

public interface IFragmentFactory {
    IFragment newFragmentFromParserTree(ITree<ITextSource> parseTree);
}

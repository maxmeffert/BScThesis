package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class FragmentFactory implements IFragmentFactory {

    @Override
    public IFragment newFragmentFromParserTree(ITree<ITextSource> parseTree) {
        return new Fragment(parseTree);
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class FragmentFactory implements IFragmentFactory {

    private final IFragmentBuilderFactory fragmentBuilderFactory;

    @Inject
    public FragmentFactory(IFragmentBuilderFactory fragmentBuilderFactory) {
        this.fragmentBuilderFactory = fragmentBuilderFactory;
    }

    @Override
    public IFragment newFragmentFromParserTree(ITree<ITextSource> parseTree) {
        return new Fragment(parseTree);
    }
}

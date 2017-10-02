package org.softlang.maxmeffert.bscthesis.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

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

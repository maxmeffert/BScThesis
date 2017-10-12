package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifact;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final IFragmentKBBuilderFactory fragmentKBBuilderFactory;
    private final IFragmentFactory fragmentFactory;

    @Inject
    public FragmentKBFactory(IFragmentKBBuilderFactory fragmentKBBuilderFactory, IFragmentFactory fragmentFactory) {
        this.fragmentKBBuilderFactory = fragmentKBBuilderFactory;
        this.fragmentFactory = fragmentFactory;
    }

    private IFragmentKBBuilder addFragments(IFragmentKBBuilder fragmentKBBuilder, ITree<ITextSource> parseTree) {
        IFragment composite = fragmentFactory.newFragmentFromParserTree(parseTree);
        for(ITree<ITextSource> child : parseTree.getChildren()) {
            IFragment component = fragmentFactory.newFragmentFromParserTree(child);
            fragmentKBBuilder = addFragments(fragmentKBBuilder.fragmentOf(component, composite), child);
        }
        return fragmentKBBuilder;
    }

    @Override
    public IFragmentKB newFragmentKB(ITree<ITextSource> parseTree) {
        return addFragments(fragmentKBBuilderFactory.newFragmentKBBuilder(), parseTree).build();
    }

    @Override
    public IFragmentKB newFragmentKB(IArtifact iArtifact) {
        return null;
    }
}

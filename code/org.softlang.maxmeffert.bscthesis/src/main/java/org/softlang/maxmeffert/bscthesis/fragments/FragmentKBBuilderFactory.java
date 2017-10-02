package org.softlang.maxmeffert.bscthesis.fragments;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.graphs.IGraphBuilders;
import org.softlang.maxmeffert.bscthesis.graphs.IGraphClosures;

public class FragmentKBBuilderFactory implements IFragmentKBBuilderFactory {

    private final IGraphClosures graphClosures;
    private final IGraphBuilders graphBuilders;

    @Inject
    public FragmentKBBuilderFactory(IGraphClosures graphClosures, IGraphBuilders graphBuilders) {
        this.graphClosures = graphClosures;
        this.graphBuilders = graphBuilders;
    }

    @Override
    public IFragmentKBBuilder newFragmentKBBuilder() {
        return new FragmentKBBuilder(graphClosures, graphBuilders.newDiGraphBuilder());
    }
}

package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraphBuilder;
import org.softlang.maxmeffert.bscthesis.graphs.closures.IGraphClosures;

public class FragmentKBBuilder implements IFragmentKBBuilder {

    private final IGraphClosures graphClosures;
    private final IDiGraphBuilder<IFragment> diGraphBuilder;

    public FragmentKBBuilder(IGraphClosures graphClosures, IDiGraphBuilder<IFragment> diGraphBuilder) {
        this.graphClosures = graphClosures;
        this.diGraphBuilder = diGraphBuilder;
    }

    @Override
    public IFragmentKBBuilder fragmentOf(IFragment component, IFragment composite) {
        System.out.println(component + " fragmentOf " + composite);
        return new FragmentKBBuilder(graphClosures, diGraphBuilder.withEdge(component, composite));
    }

    private IDiGraph<IFragment> buildFragmentGraph() {
        return graphClosures.reflexiveTransitiveDiGraphClosureOf(diGraphBuilder.build());
    }

    @Override
    public IFragmentKB build() {
        return new FragmentKB(buildFragmentGraph());
    }
}

package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public class FragmentKB implements IFragmentKB {

    private final IGraph<IFragment> graph;

    public FragmentKB(IGraph<IFragment> graph) {
        this.graph = graph;
    }

    @Override
    public Iterable<IFragment> getFragments() {
        return graph.getNodes();
    }

    @Override
    public Iterable<IFragment> getFragmentsOf(IFragment fragment) {
        return graph.getAdjacentNodesOf(fragment);
    }

    @Override
    public boolean fragmentOf(IFragment component, IFragment composite) {
        return false;
    }
}

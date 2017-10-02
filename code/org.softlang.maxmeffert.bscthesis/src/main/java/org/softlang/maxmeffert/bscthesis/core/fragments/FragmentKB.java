package org.softlang.maxmeffert.bscthesis.core.fragments;

import org.softlang.maxmeffert.bscthesis.core.graphs.IDiGraph;

public class FragmentKB implements IFragmentKB {

    private final IDiGraph<IFragment> diGraph;

    public FragmentKB(IDiGraph<IFragment> graph) {
        this.diGraph = graph;
    }

    @Override
    public Iterable<IFragment> getFragments() {
        return diGraph.getNodes();
    }

    @Override
    public Iterable<IFragment> getFragmentsOf(IFragment fragment) {
        return diGraph.getSourceNodesOf(fragment);
    }

    @Override
    public boolean fragmentOf(IFragment component, IFragment composite) {
        return false;
    }
}

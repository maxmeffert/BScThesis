package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public class DiGraphSourceIterator<TValue extends Comparable<TValue>> extends DiGraphIterator<TValue> {

    public DiGraphSourceIterator(IDiGraph<TValue> diGraph, TValue start) {
        super(diGraph, start);
    }

    @Override
    protected Iterable<TValue> getNextNodes(IDiGraph<TValue> diGraph, TValue currentNode) {
        return diGraph.getSourceNodesOf(currentNode);
    }
}

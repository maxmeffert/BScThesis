package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.IPair;

public interface IGraphBuilder<TValue extends Comparable<TValue>> {
    IGraphBuilder<TValue> withEdge(TValue node1, TValue node2);
    IGraphBuilder<TValue> withEdges(Iterable<IPair<TValue,TValue>> edges);
    IGraphBuilder<TValue> withGraph(IGraph<TValue> graph);
    IGraph<TValue> build();
}

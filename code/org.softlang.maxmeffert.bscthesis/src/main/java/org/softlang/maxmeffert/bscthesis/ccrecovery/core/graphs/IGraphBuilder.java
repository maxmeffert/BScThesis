package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

public interface IGraphBuilder<TValue extends Comparable<TValue>> {
    IGraphBuilder<TValue> withEdge(TValue node1, TValue node2);
    IGraphBuilder<TValue> withEdges(Iterable<IComparablePair<TValue,TValue>> edges);
    IGraphBuilder<TValue> withGraph(IGraph<TValue> graph);
    IGraph<TValue> build();
}

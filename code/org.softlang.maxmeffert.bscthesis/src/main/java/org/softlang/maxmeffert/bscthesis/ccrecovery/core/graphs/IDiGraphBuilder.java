package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

public interface IDiGraphBuilder<TValue extends Comparable<TValue>> {
    IDiGraphBuilder<TValue> withEdge(TValue source, TValue target);
    IDiGraphBuilder<TValue> withEdge(IComparablePair<TValue,TValue> edge);
    IDiGraphBuilder<TValue> withEdges(Iterable<IComparablePair<TValue,TValue>> edges);
    IDiGraphBuilder<TValue> withGraph(IDiGraph<TValue> diGraph);
    IDiGraph<TValue> build();
}

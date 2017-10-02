package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.iterators;

import org.softlang.maxmeffert.bscthesis.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;

public interface IGraphIterators {
    <TValue extends Comparable<TValue>> IGraphIterator<TValue> newUndirectedGraphIterator(IGraph<TValue> graph, TValue startNode);
    <TValue extends Comparable<TValue>> IGraphIterator<TValue> newDirectedGraphIterator(IDiGraph<TValue> graph, TValue startNode);
}

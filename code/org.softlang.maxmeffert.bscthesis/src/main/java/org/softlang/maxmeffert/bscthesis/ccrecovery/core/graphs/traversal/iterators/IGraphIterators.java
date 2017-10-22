package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IGraph;

public interface IGraphIterators {
    <TValue extends Comparable<TValue>> IGraphIterator<TValue> newUndirectedGraphIterator(IGraph<TValue> graph, TValue startNode);
    <TValue extends Comparable<TValue>> IGraphIterator<TValue> newDirectedGraphIterator(IDiGraph<TValue> graph, TValue startNode);
}

package org.softlang.maxmeffert.bscthesis.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphWalkFactory {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
}

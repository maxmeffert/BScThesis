package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;

public interface IGraphWalkFactory {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
}

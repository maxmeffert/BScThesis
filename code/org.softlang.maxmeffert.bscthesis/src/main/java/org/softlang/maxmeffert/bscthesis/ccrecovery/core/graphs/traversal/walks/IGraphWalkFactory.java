package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IGraph;

public interface IGraphWalkFactory {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
}

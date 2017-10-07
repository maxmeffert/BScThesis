package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IGraph;

public interface IGraphWalks {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
    <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode);
}

package org.softlang.maxmeffert.bscthesis.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphWalks {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
    <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode);
}

package org.softlang.maxmeffert.bscthesis.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.graphs.IDiGraph;

public interface IDiGraphWalkFactory {
    <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode);
}

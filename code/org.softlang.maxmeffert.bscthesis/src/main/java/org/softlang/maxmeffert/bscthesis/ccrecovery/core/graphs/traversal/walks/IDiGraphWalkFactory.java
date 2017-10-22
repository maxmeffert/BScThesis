package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IDiGraph;

public interface IDiGraphWalkFactory {
    <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode);
}

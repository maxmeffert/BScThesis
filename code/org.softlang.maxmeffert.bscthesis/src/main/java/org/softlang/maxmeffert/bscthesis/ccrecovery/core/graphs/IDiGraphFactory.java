package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IDiGraphFactory {
    <TValue extends Comparable<TValue>> IDiGraph<TValue> newDiGraph();
}

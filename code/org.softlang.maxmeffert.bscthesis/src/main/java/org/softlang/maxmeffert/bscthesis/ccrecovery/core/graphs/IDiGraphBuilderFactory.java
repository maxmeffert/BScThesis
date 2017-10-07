package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IDiGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();
}

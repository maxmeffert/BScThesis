package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IDiGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();
}

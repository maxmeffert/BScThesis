package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();
}

package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IDiGraphNodeBuilderFactory {

    <TValue extends Comparable<TValue>> IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder();

}

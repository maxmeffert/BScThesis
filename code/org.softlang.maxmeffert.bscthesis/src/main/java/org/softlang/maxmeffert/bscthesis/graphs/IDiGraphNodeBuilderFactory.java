package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNodeBuilderFactory {

    <TValue extends Comparable<TValue>> IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder();

}

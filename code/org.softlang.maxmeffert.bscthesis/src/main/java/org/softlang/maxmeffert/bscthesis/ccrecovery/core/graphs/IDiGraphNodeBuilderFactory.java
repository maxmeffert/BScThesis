package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IDiGraphNodeBuilderFactory {

    <TValue extends Comparable<TValue>> IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder();

}

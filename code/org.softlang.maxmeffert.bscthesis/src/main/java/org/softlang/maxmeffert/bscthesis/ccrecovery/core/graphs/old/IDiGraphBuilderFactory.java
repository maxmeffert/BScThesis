package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

public interface IDiGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();
}

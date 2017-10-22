package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

public interface IGraphBuilders {

    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();

}

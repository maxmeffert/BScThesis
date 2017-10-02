package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IGraphBuilders {

    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();

}

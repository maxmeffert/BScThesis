package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphs {

    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
    <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder();
    <TValue extends Comparable<TValue>> ITreeBuilder<TValue> newTreeBuilder();

}

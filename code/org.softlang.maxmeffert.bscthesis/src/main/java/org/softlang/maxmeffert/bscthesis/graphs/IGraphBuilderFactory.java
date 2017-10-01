package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
}

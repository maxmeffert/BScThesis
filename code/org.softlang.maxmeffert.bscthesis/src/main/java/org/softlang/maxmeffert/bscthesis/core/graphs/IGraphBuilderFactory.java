package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
}

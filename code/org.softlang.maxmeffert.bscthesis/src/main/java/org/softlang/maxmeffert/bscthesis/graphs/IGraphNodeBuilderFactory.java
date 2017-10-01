package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphNodeBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder();
}

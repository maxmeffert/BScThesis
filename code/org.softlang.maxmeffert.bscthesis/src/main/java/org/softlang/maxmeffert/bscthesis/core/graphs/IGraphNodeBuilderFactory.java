package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IGraphNodeBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder();
}

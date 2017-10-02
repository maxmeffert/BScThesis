package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IGraphNodeBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder();
}

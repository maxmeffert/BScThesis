package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IGraphBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder();
}

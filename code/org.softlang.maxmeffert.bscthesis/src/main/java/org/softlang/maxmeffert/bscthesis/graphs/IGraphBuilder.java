package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphBuilder<TValue extends Comparable<TValue>> {
    IGraphBuilder<TValue> withEdge(TValue node1, TValue node2);
    IGraph<TValue> build();
}

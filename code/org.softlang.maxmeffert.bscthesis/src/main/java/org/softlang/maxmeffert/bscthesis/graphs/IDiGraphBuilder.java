package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilder<TValue extends Comparable<TValue>> {
    IDiGraphBuilder<TValue> withEdge(TValue node1, TValue node2);
    IDiGraph<TValue> build();
}

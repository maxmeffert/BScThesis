package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilder<TValue extends Comparable<TValue>> {
    IDiGraphBuilder<TValue> withEdge(TValue source, TValue target);
    IDiGraph<TValue> build();
}

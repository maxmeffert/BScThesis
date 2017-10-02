package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IDiGraph<TValue extends Comparable<TValue>> extends IGraph<TValue> {
    Iterable<TValue> getSourceNodesOf(TValue node);
    Iterable<TValue> getTargetNodesOf(TValue node);
}

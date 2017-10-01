package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraph<TValue extends Comparable<TValue>> {
    boolean isEmpty();
    int getNodeCount();
    Iterable<TValue> getNodes();
    Iterable<TValue> getAdjacentNodesOf(TValue node);
}

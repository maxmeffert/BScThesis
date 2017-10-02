package org.softlang.maxmeffert.bscthesis.core.graphs;

public interface IGraphNode<TValue extends Comparable<TValue>> extends Comparable<IGraphNode<TValue>> {
    TValue getValue();
    Iterable<TValue> getAdjacentNodes();
}

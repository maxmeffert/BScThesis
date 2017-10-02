package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IGraphNode<TValue extends Comparable<TValue>> extends Comparable<IGraphNode<TValue>> {
    TValue getValue();
    Iterable<TValue> getAdjacentNodes();
}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNode<TValue extends Comparable<TValue>> extends IGraphNode<TValue> {
    Iterable<TValue> getSourceNodes();
    Iterable<TValue> getTargetNodes();
}

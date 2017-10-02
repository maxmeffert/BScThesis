package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

public interface IDiGraphNode<TValue extends Comparable<TValue>> extends IGraphNode<TValue> {
    Iterable<TValue> getSourceNodes();
    Iterable<TValue> getTargetNodes();
}

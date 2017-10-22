package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

public interface IGraphNodeBuilder<TValue extends Comparable<TValue>> {
    IGraphNodeBuilder<TValue> withValue(TValue value);
    IGraphNodeBuilder<TValue> withAdjacentNode(TValue value);
    IGraphNodeBuilder<TValue> withAdjacentNodes(Iterable<TValue> values);
    IGraphNode<TValue> build();

}

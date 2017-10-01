package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeNodeBuilder<TValue extends Comparable<TValue>> {
    ITreeNodeBuilder<TValue> withValue(TValue value);
    ITreeNodeBuilder<TValue> withParent(TValue parent);
    ITreeNodeBuilder<TValue> withChild(TValue child);
    ITreeNode<TValue> build();
}

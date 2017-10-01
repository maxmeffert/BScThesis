package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeNodeBuilder<TNode extends Comparable<TNode>> {
    ITreeNodeBuilder<TNode> withValue(TNode value);
    ITreeNodeBuilder<TNode> withParent(TNode parent);
    ITreeNodeBuilder<TNode> withChild(TNode child);
    ITreeNode<TNode> build();
}

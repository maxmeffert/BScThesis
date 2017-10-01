package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {
    ITreeBuilder<TNode,TEdge> withChild(TNode parent, TNode child, TEdge edge);
    ITree<TNode,TEdge> build();
}

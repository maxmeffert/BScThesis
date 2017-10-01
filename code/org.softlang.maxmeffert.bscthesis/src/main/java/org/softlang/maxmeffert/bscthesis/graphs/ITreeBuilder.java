package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilder<TNode extends Comparable<TNode>> {

    ITree<TNode> build();
}

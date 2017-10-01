package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilder<TNode extends Comparable<TNode>> {
    IDiGraphBuilder<TNode> withEdge(TNode node1, TNode node2);
    IDiGraph<TNode> build();
}

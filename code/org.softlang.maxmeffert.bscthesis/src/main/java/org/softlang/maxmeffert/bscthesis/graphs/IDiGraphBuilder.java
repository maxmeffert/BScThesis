package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {
    DiGraphBuilder<TNode, TEdge> withEdge(TNode node1, TNode node2, TEdge edgeValue);

    IDiGraph<TNode, TEdge> build();
}

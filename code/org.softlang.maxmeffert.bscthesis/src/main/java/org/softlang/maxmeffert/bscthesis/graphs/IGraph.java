package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraph<TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>> {
    boolean isEmpty();
    int getNodeCount();
    int getEdgeCount();
    Iterable<TNode> getNodes();
    Iterable<TNode> getAdjacentNodesOf(TNode node);
}

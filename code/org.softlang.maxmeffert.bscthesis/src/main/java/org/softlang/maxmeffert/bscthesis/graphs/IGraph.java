package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraph<TNode extends Comparable<TNode>> {
    boolean isEmpty();
    int getNodeCount();
    Iterable<TNode> getNodes();
    Iterable<TNode> getAdjacentNodesOf(TNode node);
}

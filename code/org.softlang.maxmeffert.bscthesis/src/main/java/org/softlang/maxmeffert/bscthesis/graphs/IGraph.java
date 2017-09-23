package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Map;

public interface IGraph<TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>> {
    boolean isEmpty();
    int getNodeCount();

    Iterable<TNode> getNodes();
    Iterable<TNode> getAdjacentNodesOf(TNode node);
    Map<TNode,TEdge> getAdjacentEdgesOf(TNode node);
}

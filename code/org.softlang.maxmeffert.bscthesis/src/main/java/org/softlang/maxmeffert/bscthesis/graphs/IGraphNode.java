package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Map;

public interface IGraphNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends Comparable<IGraphNode<TNode,TEdge>> {
    TNode getValue();
    Iterable<TNode> getAdjacentNodes();
    Map<TNode,TEdge> getAdjacentEdges();
}

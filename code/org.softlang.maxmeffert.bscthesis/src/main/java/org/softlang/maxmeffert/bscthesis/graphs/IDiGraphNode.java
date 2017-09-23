package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Map;

public interface IDiGraphNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends IGraphNode<TNode,TEdge> {
    Iterable<TNode> getSourceNodes();
    Iterable<TNode> getTargetNodes();
    Map<TNode,TEdge> getSourceEdges();
    Map<TNode,TEdge> getTargetEdges();
}

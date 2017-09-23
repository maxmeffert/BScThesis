package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Map;

public interface IDiGraph<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends IGraph<TNode,TEdge> {
    Iterable<TNode> getSourceNodesOf(TNode node);
    Iterable<TNode> getTargetNodesOf(TNode node);
    Map<TNode,TEdge> getSourceEdgesOf(TNode node);
    Map<TNode,TEdge> getTargetEdgesOf(TNode node);
}

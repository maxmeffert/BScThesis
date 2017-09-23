package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.tuples.IPair;

public interface IDiGraphNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends IGraphNode<TNode,TEdge> {
    Iterable<IPair<TNode,TEdge>> getSourceEdges();
    Iterable<IPair<TNode,TEdge>> getTargetEdges();
}

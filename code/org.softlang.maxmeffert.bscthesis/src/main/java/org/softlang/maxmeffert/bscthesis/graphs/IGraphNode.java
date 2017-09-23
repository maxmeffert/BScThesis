package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.tuples.IPair;

public interface IGraphNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends Comparable<IGraphNode<TNode,TEdge>> {
    TNode getValue();
    Iterable<IPair<TNode,TEdge>> getAdjacentEdges();
}

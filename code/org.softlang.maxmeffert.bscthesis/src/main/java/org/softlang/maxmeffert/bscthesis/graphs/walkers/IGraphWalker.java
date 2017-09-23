package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphWalker<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {
    void walk(IGraph<TNode,TEdge> graph, IGraphWalkerListener<TNode> graphWalkerListener);
}

package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphWalker<TNode extends Comparable<TNode>> {
    void walk(IGraph<TNode> graph, TNode start, IGraphWalkerListener<TNode> graphWalkerListener);
}

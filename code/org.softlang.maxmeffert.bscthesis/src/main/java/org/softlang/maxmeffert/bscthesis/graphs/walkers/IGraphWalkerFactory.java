package org.softlang.maxmeffert.bscthesis.graphs.walkers;

public interface IGraphWalkerFactory {
    <TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>>
    IGraphWalker<TNode,TEdge> newGraphWalker();
}

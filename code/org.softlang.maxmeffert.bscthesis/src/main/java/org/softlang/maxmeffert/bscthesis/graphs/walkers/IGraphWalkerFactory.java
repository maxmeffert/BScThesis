package org.softlang.maxmeffert.bscthesis.graphs.walkers;

public interface IGraphWalkerFactory {
    <TNode extends Comparable<TNode>> IGraphWalker<TNode> newGraphWalker();
}

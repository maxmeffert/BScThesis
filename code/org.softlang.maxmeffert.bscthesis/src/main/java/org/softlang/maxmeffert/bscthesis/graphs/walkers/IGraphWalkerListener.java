package org.softlang.maxmeffert.bscthesis.graphs.walkers;

public interface IGraphWalkerListener<TNode extends Comparable<TNode>> {
    void enter(TNode node);
    void exit(TNode node);
}

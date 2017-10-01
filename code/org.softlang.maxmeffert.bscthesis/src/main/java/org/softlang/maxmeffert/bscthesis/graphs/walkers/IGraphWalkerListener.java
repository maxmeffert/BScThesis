package org.softlang.maxmeffert.bscthesis.graphs.walkers;

public interface IGraphWalkerListener<TValue extends Comparable<TValue>> {
    void enter(TValue node);
    void exit(TValue node);
}

package org.softlang.maxmeffert.bscthesis.graphs.walkers;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

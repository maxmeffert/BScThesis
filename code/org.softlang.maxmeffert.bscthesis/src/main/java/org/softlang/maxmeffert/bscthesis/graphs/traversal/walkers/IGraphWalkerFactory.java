package org.softlang.maxmeffert.bscthesis.graphs.traversal.walkers;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

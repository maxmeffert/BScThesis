package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walkers;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

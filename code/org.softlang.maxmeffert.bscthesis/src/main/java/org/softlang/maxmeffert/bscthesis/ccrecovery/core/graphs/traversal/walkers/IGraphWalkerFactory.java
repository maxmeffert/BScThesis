package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

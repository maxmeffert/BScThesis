package org.softlang.maxmeffert.bscthesis.graphs.traversal;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

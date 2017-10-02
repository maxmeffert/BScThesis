package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphWalkerFactory {
    <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker();
}

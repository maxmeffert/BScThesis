package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphWalker<TValue extends Comparable<TValue>> {
    void walk(IGraph<TValue> graph, TValue start, IGraphWalkerListener<TValue> graphWalkerListener);
}

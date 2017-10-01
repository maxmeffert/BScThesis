package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphWalker<TValue extends Comparable<TValue>> {
    void walk(IGraph<TValue> graph, TValue start, IGraphWalkerListener<TValue> graphWalkerListener);
}

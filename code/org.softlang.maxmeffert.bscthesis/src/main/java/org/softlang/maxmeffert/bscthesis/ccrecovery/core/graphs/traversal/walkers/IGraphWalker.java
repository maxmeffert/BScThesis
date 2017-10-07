package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IGraph;

public interface IGraphWalker<TValue extends Comparable<TValue>> {
    void walk(IGraph<TValue> graph, TValue start, IGraphWalkerListener<TValue> graphWalkerListener);
}

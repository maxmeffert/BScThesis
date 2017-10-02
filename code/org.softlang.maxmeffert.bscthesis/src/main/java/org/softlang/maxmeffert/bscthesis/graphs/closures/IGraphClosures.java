package org.softlang.maxmeffert.bscthesis.graphs.closures;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

public interface IGraphClosures {
    <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveClosureOf(IGraph<TValue> graph);
    <TValue extends Comparable<TValue>> IGraph<TValue> transitiveClosureOf(IGraph<TValue> graph);
    <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveTransitiveClosureOf(IGraph<TValue> graph);
}

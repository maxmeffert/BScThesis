package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphClosures {
    <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveClosureOf(IGraph<TValue> graph);
}

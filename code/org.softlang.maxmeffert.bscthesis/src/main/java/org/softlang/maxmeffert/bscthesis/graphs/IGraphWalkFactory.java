package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphWalkFactory {
    <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode);
}

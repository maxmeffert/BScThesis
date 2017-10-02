package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphIteratorFactory {
    <TValue extends Comparable<TValue>> IGraphIterator<TValue> newGraphIterator(IGraph<TValue> graph, TValue startNode);
}

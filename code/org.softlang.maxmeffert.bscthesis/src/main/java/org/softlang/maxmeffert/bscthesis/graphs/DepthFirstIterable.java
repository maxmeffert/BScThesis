package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Iterator;

public class DepthFirstIterable<T extends Comparable<T>> implements Iterable<T> {

    private final IGraph<T> graph;
    private final T startVertex;

    public DepthFirstIterable(IGraph<T> graph, T startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
    }

    @Override
    public Iterator<T> iterator() {
        return DepthFirstIterator.of(graph, startVertex);
    }
}

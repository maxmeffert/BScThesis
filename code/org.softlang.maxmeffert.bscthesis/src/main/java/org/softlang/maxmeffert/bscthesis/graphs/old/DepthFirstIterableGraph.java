package org.softlang.maxmeffert.bscthesis.graphs.old;

import java.util.Iterator;

public class DepthFirstIterableGraph<T extends Comparable<T>> extends GraphProxy<T> implements IIterableGraph<T> {

    public static <T extends Comparable<T>> DepthFirstIterableGraph<T> of(IGraph<T> graph, T startVertex) {
        return new DepthFirstIterableGraph<>(graph, startVertex);
    }

    private final T startVertex;

    public DepthFirstIterableGraph(IGraph<T> graph, T startVertex) {
        super(graph);
        this.startVertex = startVertex;
    }

    @Override
    public Iterator<T> iterator() {
        return DepthFirstIterator.of(graph::getAdjacentVerticesOf, startVertex);
    }
}

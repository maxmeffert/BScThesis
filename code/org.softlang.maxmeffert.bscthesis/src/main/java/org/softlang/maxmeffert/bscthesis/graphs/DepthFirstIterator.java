package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

public class DepthFirstIterator<T extends Comparable<T>> implements Iterator<T> {

    public static <T extends Comparable<T>> DepthFirstIterator<T> of(Function<T, Iterable<T>> nextVerticesProvider, T startVertex) {
        return new DepthFirstIterator<>(nextVerticesProvider, startVertex);
    }

    public static <T extends Comparable<T>> DepthFirstIterator<T> of(IGraph<T> graph, T startVertex) {
        return of(v -> graph.getAdjacentVerticesOf(v), startVertex);
    }

    private final Function<T, Iterable<T>> nextVerticesProvider;
    private final Set<T> discoveredVertices = Sets.newTreeSet();
    private final Stack<T> nextVertices = new Stack<>();

    public DepthFirstIterator(Function<T, Iterable<T>> nextVerticesProvider, T startVertex) {
        this.nextVerticesProvider = nextVerticesProvider;
        nextVertices.push(startVertex);
    }

    @Override
    public boolean hasNext() {
        return !nextVertices.isEmpty();
    }

    private boolean isDiscovered(T vertex) {
        return discoveredVertices.contains(vertex);
    }

    private boolean isNotDiscovered(T vertex) {
        return !isDiscovered(vertex);
    }

    private void markAsDiscovered(T vertex) {
        discoveredVertices.add(vertex);
    }

    private void addNextVertices(Iterable<T> vertices) {
        for (T vertex : vertices) {
            if (isNotDiscovered(vertex)) {
                nextVertices.push(vertex);
            }
        }
    }

    private void addNextVerticesAdjacentVerticesOf(T vertex) {
        addNextVertices(nextVerticesProvider.apply(vertex));
    }

    @Override
    public T next() {
        T nextVertex = nextVertices.pop();
        markAsDiscovered(nextVertex);
        addNextVerticesAdjacentVerticesOf(nextVertex);
        return nextVertex;
    }
}

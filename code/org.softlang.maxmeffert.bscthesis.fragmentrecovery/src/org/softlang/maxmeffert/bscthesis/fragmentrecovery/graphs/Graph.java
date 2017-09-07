package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;

import java.util.Set;

public class Graph<T extends Comparable<T>> implements IGraph<T> {

    public static class Builder<T extends Comparable<T>> implements IGraphBuilder<T, Graph<T>> {

        public static <T extends Comparable<T>> Builder<T> get() {
            return new Builder<>();
        }

        @Override
        public void add(T vertex1, T vertex2) {

        }

        @Override
        public void add(IPair<T, T> edge) {

        }

        @Override
        public void add(Iterable<IPair<T, T>> edges) {

        }

        @Override
        public Graph<T> build() {
            return null;
        }
    }

    @Override
    public Set<T> getVertices() {
        return null;
    }

    @Override
    public Set<IPair<T, T>> getEdges() {
        return null;
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsVertex(T vertex) {
        return false;
    }

    @Override
    public boolean containsEdge(T source, T target) {
        return false;
    }

    @Override
    public boolean containsEdge(IPair<T, T> edge) {
        return false;
    }

    @Override
    public IAdjacencyMatrix toAdjacencyMatrix() {
        return null;
    }
}

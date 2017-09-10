package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Map;
import java.util.Set;

public class Graph<T extends Comparable<T>> implements IGraph<T> {

    public static class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

        private final T value;
        private final Map<T, Vertex<T>> adjacentVertices = Maps.newTreeMap();

        public Vertex(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Set<T> getAdjacentVertices() {
            return adjacentVertices.keySet();
        }

        public void addAdjacentVertex(Vertex<T> adjacentVertex) {
            if (adjacentVertices.containsKey(adjacentVertex.value)) {
                return;
            }
            adjacentVertices.put(adjacentVertex.value, adjacentVertex);
            adjacentVertex.addAdjacentVertex(this);
        }

        @Override
        public int compareTo(Vertex<T> tVertex) {
            return value.compareTo(tVertex.value);
        }
    }

    private final ImmutableSortedMap<T, Vertex<T>> vertices;

    public Graph(ImmutableSortedMap<T, Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    @Override
    public Set<T> getVertices() {
        return vertices.keySet();
    }

    @Override
    public Set<IPair<T, T>> getEdges() {
        return null;
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return vertices.get(vertex).getAdjacentVertices();
    }

    @Override
    public int getVertexCount() {
        return vertices.size();
    }

    @Override
    public int getEdgeCount() {
        return getEdges().size();
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

}

package org.softlang.maxmeffert.bscthesis.graphs.old;

import com.google.common.collect.*;
import org.softlang.maxmeffert.bscthesis.tuples.IPair;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<T extends Comparable<T>> implements IGraph<T> {

    public enum Direction {
        INGOING,
        OUTGOING,
        UNDIRECTED
    }

    public static class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

        public static <T extends Comparable<T>> Edge<T> of(Direction direction, T vertex1, T vertex2) {
            return new Edge<>(direction, vertex1, vertex2);
        }

        private final Direction direction;
        private final T vertex1;
        private final T vertex2;

        public Edge(Direction direction, T vertex1, T vertex2) {
            this.direction = direction;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public Direction getDirection() {
            return direction;
        }

        public T getVertex1() {
            return vertex1;
        }

        public T getVertex2() {
            return vertex2;
        }

        @Override
        public int compareTo(Edge<T> tEdge) {
            int result = direction.compareTo(tEdge.direction);
            if (result == 0) {
                result = vertex1.compareTo(tEdge.vertex1);
                if (result == 0) {
                    return vertex2.compareTo(tEdge.vertex2);
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return "(" + direction + "," + vertex1 + "," + vertex2 + ")";
        }
    }

    public static class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

        private final T value;
        private final SortedMap<T, Vertex<T>> ingoingAdjacentVertices = Maps.newTreeMap();
        private final SortedMap<T, Vertex<T>> outgoingAdjacentVertices = Maps.newTreeMap();
        private final SortedMap<T, Vertex<T>> undirectedAdjacentVertices = Maps.newTreeMap();

        public Vertex(T value) {
            this.value = value;
        }

        public Set<T> getIngoingAdjacentVertices() {
            return ingoingAdjacentVertices.keySet();
        }

        public Set<T> getOutgoingAdjacentVertices() {
            return outgoingAdjacentVertices.keySet();
        }

        public Set<T> getUndirectedAdjacentVertices() {
            return undirectedAdjacentVertices.keySet();
        }

        public Set<T> getAdjacentVertices() {
            Set<T> adjacentVertices = Sets.newTreeSet();
            adjacentVertices.addAll(getIngoingAdjacentVertices());
            adjacentVertices.addAll(getOutgoingAdjacentVertices());
            adjacentVertices.addAll(getUndirectedAdjacentVertices());
            return adjacentVertices;
        }

        public Set<T> getAdjacentVertices(Direction direction) {
            switch (direction) {
                case INGOING:
                    return getIngoingAdjacentVertices();
                case OUTGOING:
                    return getOutgoingAdjacentVertices();
                case UNDIRECTED:
                    return getUndirectedAdjacentVertices();
                default:
                    return getAdjacentVertices();
            }
        }

        public Set<Edge<T>> getIngoingEdges() {
            return getIngoingAdjacentVertices().stream()
                    .map(vertex -> Edge.of(Direction.INGOING, value, vertex))
                    .collect(Collectors.toCollection(Sets::newTreeSet));
        }

        public Set<Edge<T>> getOutgoingEdges() {
            return getOutgoingAdjacentVertices().stream()
                    .map(vertex -> Edge.of(Direction.OUTGOING, value, vertex))
                    .collect(Collectors.toCollection(Sets::newTreeSet));
        }

        public Set<Edge<T>> getUndirectedEdges() {
            return getOutgoingAdjacentVertices().stream()
                    .map(vertex -> Edge.of(Direction.UNDIRECTED, value, vertex))
                    .collect(Collectors.toCollection(Sets::newTreeSet));
        }

        public Set<Edge<T>> getEdges() {
            Set<Edge<T>> edges = Sets.newTreeSet();
            edges.addAll(getIngoingEdges());
            edges.addAll(getOutgoingEdges());
            edges.addAll(getUndirectedEdges());
            return edges;
        }

        public Set<Edge<T>> getEdges(Direction direction) {
            switch (direction) {
                case INGOING:
                    return getIngoingEdges();
                case OUTGOING:
                    return getOutgoingEdges();
                case UNDIRECTED:
                    return getUndirectedEdges();
                default:
                    return getEdges();
            }
        }

        public boolean hasIngoingAdjacentVertex(T vertex) {
            return ingoingAdjacentVertices.containsKey(vertex);
        }

        public boolean hasIngoingAdjacentVertex(Vertex<T> vertex) {
            return hasIngoingAdjacentVertex(vertex.value);
        }

        public boolean hasOutgoingAdjacentVertex(T vertex) {
            return outgoingAdjacentVertices.containsKey(vertex);
        }

        public boolean hasOutgoingAdjacentVertex(Vertex<T> vertex) {
            return hasOutgoingAdjacentVertex(vertex.value);
        }

        public boolean hasUndirectedAdjacentVertex(T vertex) {
            return undirectedAdjacentVertices.containsKey(vertex);
        }

        public boolean hasUndirectedAdjacentVertex(Vertex<T> vertex) {
            return hasOutgoingAdjacentVertex(vertex.value);
        }

        public boolean isIngoingAdjacentVertexOf(T vertex) {
            return hasOutgoingAdjacentVertex(vertex);
        }

        public boolean isIngoingAdjacentVertexOf(Vertex<T> vertex) {
            return isIngoingAdjacentVertexOf(vertex.value);
        }

        public boolean isOutgoingAdjacentVertexOf(T vertex) {
            return hasIngoingAdjacentVertex(vertex);
        }

        public boolean isOutgoingAdjacentVertexOf(Vertex<T> vertex) {
            return isOutgoingAdjacentVertexOf(vertex.value);
        }

        public boolean isUndirectedAdjacentVertexOf(T vertex) {
            return hasUndirectedAdjacentVertex(vertex);
        }

        public boolean isUndirectedAdjacentVertexOf(Vertex<T> vertex) {
            return isUndirectedAdjacentVertexOf(vertex.value);
        }

        public boolean isAdjacentTo(T vertex) {
            return isIngoingAdjacentVertexOf(vertex)
                    || isOutgoingAdjacentVertexOf(vertex)
                    || isUndirectedAdjacentVertexOf(vertex);
        }

        public boolean isAdjacentTo(Vertex<T> vertex) {
            return isAdjacentTo(vertex.value);
        }

        public void addIngoingAdjacentVertex(Vertex<T> vertex) {
            if (hasIngoingAdjacentVertex(vertex.value)) {
                return;
            }
            ingoingAdjacentVertices.put(vertex.value, vertex);
            vertex.addOutgoingAdjacentVertex(this);
        }

        public void addOutgoingAdjacentVertex(Vertex<T> vertex) {
            if (hasOutgoingAdjacentVertex(vertex.value)) {
                return;
            }
            outgoingAdjacentVertices.put(vertex.value, vertex);
            vertex.addIngoingAdjacentVertex(this);
        }

        public void addUndirectedAdjacentVertex(Vertex<T> vertex) {
            if (hasUndirectedAdjacentVertex(vertex) || vertex.hasUndirectedAdjacentVertex(this)) {
                return;
            }
            undirectedAdjacentVertices.put(vertex.value, vertex);
            vertex.addUndirectedAdjacentVertex(this);
        }

        public void addAdjacentVertex(Direction direction, Vertex<T> vertex) {
            System.out.println(direction + "," + vertex.value);
            switch (direction) {
                case INGOING:
                    addIngoingAdjacentVertex(vertex);
                    return;
                case OUTGOING:
                    addOutgoingAdjacentVertex(vertex);
                    return;
                case UNDIRECTED:
                    addUndirectedAdjacentVertex(vertex);
                    return;
            }
        }

        @Override
        public int compareTo(Vertex<T> tVertex) {
            return value.compareTo(tVertex.value);
        }

        public T getValue() {
            return value;
        }
    }

    public static class Builder<T extends Comparable<T>> {

        private final SortedSet<Edge<T>> edges = Sets.newTreeSet();

        private Builder<T> addEdge(Edge<T> edge) {
            edges.add(edge);
            return this;
        }

        private Builder<T> addEdge(Direction direction, T vertex1, T vertex2) {
            return addEdge(Edge.of(direction, vertex1, vertex2));
        }

        public Builder<T> addIngoingEdge(T vertex1, T vertex2) {
            return addEdge(Direction.INGOING, vertex1, vertex2);
        }

        public Builder<T> addOutgoingEdge(T vertex1, T vertex2) {
            return addEdge(Direction.OUTGOING, vertex1, vertex2);
        }

        public Builder<T> addUndirectedEdge(T vertex1, T vertex2) {
            return addEdge(Direction.UNDIRECTED, vertex1, vertex2);
        }

        private Vertex<T> getAndPutVertexIfNotExists(T value, Map<T, Vertex<T>> map) {
            if (!map.containsKey(value)) {
                map.put(value, new Vertex<>(value));
            }
            return map.get(value);
        }

        private ImmutableSortedMap<T, Vertex<T>> buildVertexMap() {
            SortedMap<T,Vertex<T>> map = Maps.newTreeMap();
            for (Edge<T> edge : edges) {
                Direction direction = edge.getDirection();
                Vertex<T> vertex1 = getAndPutVertexIfNotExists(edge.getVertex1(), map);
                Vertex<T> vertex2 = getAndPutVertexIfNotExists(edge.getVertex2(), map);
                vertex1.addAdjacentVertex(direction, vertex2);
            }
            return ImmutableSortedMap.copyOfSorted(map);
        }

        public Graph<T> build() {
            return new Graph<>(buildVertexMap());
        }
    }

    private final SortedMap<T, Vertex<T>> vertices;

    public Graph(SortedMap<T, Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    @Override
    public Optional<T> getFirstVertex() {
        for (T vertex : getVertices()) {
            return Optional.of(vertex);
        }
        return Optional.empty();
    }

    @Override
    public Set<T> getVertices() {
        return vertices.keySet();
    }

    public Set<Edge<T>> foo() {
        Set<Edge<T>> edges = Sets.newTreeSet();
        for (T vertex : getVertices()) {
            System.out.println(vertex);
            System.out.println(vertices.get(vertex).getEdges());
            edges.addAll(vertices.get(vertex).getEdges());
        }
        return edges;
    }

    @Override
    public Set<IPair<T, T>> getEdges() {
        Set<IPair<T,T>> edges = Sets.newTreeSet();
        for (T vertex : getVertices()) {

        }
        return edges;
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return vertices.get(vertex).getAdjacentVertices();
    }

    public Set<T> getAdjacentVerticesOf(T vertex, Direction direction) {
        return vertices.get(vertex).getAdjacentVertices(direction);
    }

    @Override
    public int getVertexCount() {
        return getVertices().size();
    }

    @Override
    public int getEdgeCount() {
        return getEdges().size();
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return getEdges().toString();
    }
}

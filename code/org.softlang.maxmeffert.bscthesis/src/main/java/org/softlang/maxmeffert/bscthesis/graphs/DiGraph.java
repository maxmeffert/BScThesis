package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.*;
import org.softlang.maxmeffert.bscthesis.utils.IPair;
import org.softlang.maxmeffert.bscthesis.utils.Pair;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;

public class DiGraph<T extends Comparable<T>> extends AbstractGraph<T> implements IDiGraph<T> {

    public static class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

        private final T value;
        private final Map<T, Vertex<T>> sources = Maps.newTreeMap();
        private final Map<T, Vertex<T>> targets = Maps.newTreeMap();

        public Vertex(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Set<T> getSources() {
            return sources.keySet();
        }

        public boolean hasSource(T source) {
            return sources.containsKey(source);
        }

        public boolean hasSource(Vertex<T> source) {
            return hasSource(source.getValue());
        }

        public void addSource(Vertex<T> source) {
            if (hasSource(source)) {
                return;
            }
            sources.put(source.getValue(), source);
            source.addTarget(this);
        }

        public Set<T> getTargets() {
            return targets.keySet();
        }

        public boolean hasTarget(T target) {
            return targets.containsKey(target);
        }

        public boolean hasTarget(Vertex<T> target) {
            return hasTarget(target.getValue());
        }

        public void addTarget(Vertex<T> target) {
            if (hasTarget(target)) {
                return;
            }
            targets.put(target.getValue(), target);
            target.addSource(this);
        }

        @Override
        public int compareTo(Vertex<T> tVertex) {
            return value.compareTo(tVertex.value);
        }

        public boolean equals(Vertex<T> vertex) {
            return compareTo(vertex) == 0;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }

    public static class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

        public static <T extends Comparable<T>> Edge<T> of(T source, T target) {
            return new Edge<>(source, target);
        }

        private final T source;
        private final T target;

        public Edge(T source, T target) {
            this.source = source;
            this.target = target;
        }

        public T getSource() {
            return source;
        }

        public T getTarget() {
            return target;
        }

        @Override
        public int compareTo(Edge<T> tEdge) {
            int result = source.compareTo(tEdge.source);
            if (result == 0) {
                return target.compareTo(tEdge.target);
            }
            return result;
        }
    }

    public static class Builder<T extends Comparable<T>> implements IGraphBuilder<T, DiGraph<T>> {

        public static <T extends Comparable<T>> Builder<T> get() {
            return new Builder<>();
        }

        private Set<Edge<T>> edges = Sets.newTreeSet();

        public void add(T source, T target) {
            edges.add(Edge.of(source, target));
        }

        @Override
        public void add(IPair<T, T> edge) {
            add(edge.getFirst(), edge.getSecond());
        }

        @Override
        public void add(Iterable<IPair<T, T>> edges) {
            Streams.stream(edges).forEach(this::add);
        }

        @Override
        public void add(IGraph<T> graph) {
            add(graph.getEdges());
        }

        private Vertex<T> getAndPutVertexIfNotExists(T value, Map<T, Vertex<T>> map) {
            if (!map.containsKey(value)) {
                map.put(value, new Vertex<>(value));
            }
            return map.get(value);
        }

        public ImmutableSortedMap<T,Vertex<T>> buildVertexMap() {
            SortedMap<T,Vertex<T>> map = Maps.newTreeMap();
            for (Edge<T> edge : edges) {
                Vertex<T> source = getAndPutVertexIfNotExists(edge.getSource(), map);
                Vertex<T> target = getAndPutVertexIfNotExists(edge.getTarget(), map);
                source.addTarget(target);
            }
            return ImmutableSortedMap.copyOfSorted(map);
        }

        public DiGraph<T> build() {
            return new DiGraph<>(buildVertexMap());
        }
    }

    private final ImmutableSortedMap<T, Vertex<T>> vertices;

    public DiGraph(ImmutableSortedMap<T, Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public Set<T> getVertices() {
        return vertices.keySet();
    }

    @Override
    public Set<IPair<T, T>> getEdges() {
        Set<IPair<T,T>> edges = Sets.newTreeSet();
        for (T source : getVertices()) {
            for (T target : getTargetsOf(source)) {
                edges.add(new Pair<>(source, target));
            }
        }
        return edges;
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return getTargetsOf(vertex);
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

    @Override
    public Set<T> getSourcesOf(T target) {
        return vertices.get(target).getSources();
    }

    @Override
    public Set<T> getTargetsOf(T source) {
        return vertices.get(source).getTargets();
    }

    @Override
    public String toString() {
        return getEdges().toString();
    }
}

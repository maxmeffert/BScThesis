package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Maps;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IAdjacencyMatrix;

import java.util.Map;
import java.util.Set;

public class DiGraph<T extends Comparable<T>> implements IGraph<T>, IDiGraph<T> {

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
    }

    public static class Builder<T extends Comparable<T>> {

        public static <T extends Comparable<T>> Builder<T> get() {
            return new Builder<>();
        }

        private final Map<T,Vertex<T>> vertices = Maps.newTreeMap();

        private Vertex<T> addVertexIfNotExists(T value) {
            if (!vertices.containsKey(value)) {
                vertices.put(value, new Vertex<T>(value));
            }
            return vertices.get(value);
        }

        public void add(T source, T target) {
            Vertex<T> sourceVertex = addVertexIfNotExists(source);
            Vertex<T> targetVertex = addVertexIfNotExists(target);
            sourceVertex.addTarget(targetVertex);
        }

        public DiGraph<T> build() {
            return new DiGraph<>(vertices);
        }
    }

    private final Map<T, Vertex<T>> vertices;

    protected DiGraph(Map<T, Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public Set<T> getVertices() {
        return vertices.keySet();
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return getTargetsOf(vertex);
    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(T source, T target) {
        return vertices.containsKey(source) && vertices.get(source).hasTarget(target);
    }

    @Override
    public IAdjacencyMatrix toAdjacencyMatrix() {
        return null;
    }

    @Override
    public Set<T> getSourcesOf(T target) {
        return vertices.get(target).getSources();
    }

    @Override
    public Set<T> getTargetsOf(T source) {
        return vertices.get(source).getTargets();
    }

    private Vertex<T> getVertex(T value) {
        if (!vertices.containsKey(value)) {
            vertices.put(value, new Vertex<>(value));
        }
        return vertices.get(value);
    }
}

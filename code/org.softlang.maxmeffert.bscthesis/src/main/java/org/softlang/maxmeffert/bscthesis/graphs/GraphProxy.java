package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.utils.IAdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Set;

public abstract class GraphProxy<T extends Comparable<T>> implements IGraph<T> {

    protected final IGraph<T> graph;

    protected GraphProxy(IGraph<T> graph) {
        this.graph = graph;
    }

    @Override
    public Set<T> getVertices() {
        return graph.getVertices();
    }

    @Override
    public Set<IPair<T, T>> getEdges() {
        return graph.getEdges();
    }

    @Override
    public Set<T> getAdjacentVerticesOf(T vertex) {
        return graph.getAdjacentVerticesOf(vertex);
    }

    @Override
    public boolean isEmpty() {
        return graph.isEmpty();
    }

    @Override
    public boolean contains(IPair<T, T> pair) {
        return graph.contains(pair);
    }

    @Override
    public boolean containsVertex(T vertex) {
        return graph.containsVertex(vertex);
    }

    @Override
    public boolean containsEdge(T source, T target) {
        return graph.containsEdge(source, target);
    }

    @Override
    public boolean containsEdge(IPair<T, T> edge) {
        return graph.containsEdge(edge);
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}

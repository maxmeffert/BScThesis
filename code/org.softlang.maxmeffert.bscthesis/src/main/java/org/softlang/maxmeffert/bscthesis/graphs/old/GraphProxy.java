package org.softlang.maxmeffert.bscthesis.graphs.old;

import org.softlang.maxmeffert.bscthesis.tuples.IPair;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class GraphProxy<T extends Comparable<T>> implements IGraph<T> {

    protected final IGraph<T> graph;

    protected GraphProxy(IGraph<T> graph) {
        this.graph = graph;
    }

    @Override
    public Optional<T> getFirstVertex() {
        return graph.getFirstVertex();
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
    public int getVertexCount() {
        return graph.getVertexCount();
    }

    @Override
    public int getEdgeCount() {
        return graph.getEdgeCount();
    }

    @Override
    public boolean isEmpty() {
        return graph.isEmpty();
    }

    @Override
    public String toString() {
        return graph.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return graph.iterator();
    }
}

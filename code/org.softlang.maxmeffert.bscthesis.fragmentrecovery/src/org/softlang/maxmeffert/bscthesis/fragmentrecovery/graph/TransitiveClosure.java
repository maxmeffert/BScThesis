package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

public class TransitiveClosure<T extends Comparable<T>> implements IGraph<T> {

    public static <T extends Comparable<T>> TransitiveClosure<T> of(IGraph<T> graph) {
        return new TransitiveClosure<>(graph);
    }

    private final IGraph<T> graph;

    private TransitiveClosure(IGraph<T> graph) {
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
    public boolean containsVertex(T vertex) {
        return graph.containsVertex(vertex);
    }

    @Override
    public boolean containsEdge(T source, T target) {
        return GraphWalker.<T>get().findDepthFirst(graph, source, v -> target.compareTo(v) == 0);
    }

    @Override
    public boolean containsEdge(IPair<T, T> edge) {
        return containsEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public IAdjacencyMatrix toAdjacencyMatrix() {
        throw new NotImplementedException();
    }
}

package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.utils.IPair;

public class ReflexiveTransitiveClosure<T extends Comparable<T>> extends GraphProxy<T> {

    public static <T extends Comparable<T>> ReflexiveTransitiveClosure<T> of(IGraph<T> graph) {
        return new ReflexiveTransitiveClosure<>(graph);
    }

    protected ReflexiveTransitiveClosure(IGraph<T> graph) {
        super(graph);
    }

    @Override
    public boolean containsEdge(T source, T target) {
        return GraphWalker.<T>get().findDepthFirst(graph, source, v -> target.compareTo(v) == 0);
    }

    @Override
    public boolean containsEdge(IPair<T, T> edge) {
        return containsEdge(edge.getFirst(), edge.getSecond());
    }

}

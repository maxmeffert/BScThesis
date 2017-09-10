package org.softlang.maxmeffert.bscthesis.graphs;

public class ReflexiveTransitiveClosure<T extends Comparable<T>> extends GraphProxy<T> {

    public static <T extends Comparable<T>> ReflexiveTransitiveClosure<T> of(IGraph<T> graph) {
        return new ReflexiveTransitiveClosure<>(graph);
    }

    protected ReflexiveTransitiveClosure(IGraph<T> graph) {
        super(graph);
    }

}

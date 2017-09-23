package org.softlang.maxmeffert.bscthesis.graphs.old;

public class ReflexiveClosure<T extends Comparable<T>> extends GraphProxy<T> {

    public static <T extends Comparable<T>> ReflexiveClosure<T> of(IGraph<T> graph) {
        return new ReflexiveClosure<>(graph);
    }

    protected ReflexiveClosure(IGraph<T> graph) {
        super(graph);
    }
}

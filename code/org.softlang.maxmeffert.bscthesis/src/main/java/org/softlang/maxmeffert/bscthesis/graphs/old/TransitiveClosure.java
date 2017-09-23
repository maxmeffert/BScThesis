package org.softlang.maxmeffert.bscthesis.graphs.old;

public class TransitiveClosure<T extends Comparable<T>> extends GraphProxy<T> {

    public static <T extends Comparable<T>> TransitiveClosure<T> of(IGraph<T> graph) {
        return new TransitiveClosure<>(graph);
    }

    protected TransitiveClosure(IGraph<T> graph) {
        super(graph);
    }
}

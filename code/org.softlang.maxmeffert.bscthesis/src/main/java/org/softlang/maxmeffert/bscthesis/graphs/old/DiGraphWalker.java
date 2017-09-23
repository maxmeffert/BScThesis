package org.softlang.maxmeffert.bscthesis.graphs.old;

import java.util.function.Consumer;

public class DiGraphWalker<T extends Comparable<T>> extends GraphWalker<T> implements IDiGraphWalker<T>  {

    public static <T extends Comparable<T>> DiGraphWalker<T> get() {
        return new DiGraphWalker<>();
    }

    @Override
    public void walkDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer) {
        walkDepthFirst(diGraph, start, consumer);
    }

    @Override
    public void walkBackwardsDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer) {
        walkDepthFirst(v -> diGraph.getSourcesOf(v), start,  consumer);
    }
}

package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.function.Consumer;

public interface IDiGraphWalker<T extends Comparable<T>> {
    void walkDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer);
    void walkBackDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer);
}

package org.softlang.maxmeffert.bscthesis.graphs.old;

import java.util.function.Consumer;

public interface IDiGraphWalker<T extends Comparable<T>> {
    void walkDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer);
    void walkBackwardsDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer);
}

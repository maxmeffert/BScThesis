package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.function.Consumer;

public interface IDiGraphWalker<T extends Comparable<T>> {
    void walk(IDiGraph<T> diGraph, T start, Consumer<T> consumer);
}

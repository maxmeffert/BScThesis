package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.Set;

public interface IDiGraph<T extends Comparable<T>> {

    Set<T> getVertices();
    Set<T> getSourcesOf(T target);
    Set<T> getTargetsOf(T source);

    void add(T source, T target);
    boolean contains(T source, T target);

}

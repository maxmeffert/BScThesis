package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Set;

public interface IDiGraph<T extends Comparable<T>> extends IGraph<T> {

    Set<T> getVertices();
    Set<T> getSourcesOf(T target);
    Set<T> getTargetsOf(T source);

}

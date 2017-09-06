package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.Set;

public interface IDiGraph<T extends Comparable<T>> extends IGraph<T> {

    Set<T> getVertices();
    Set<T> getSourcesOf(T target);
    Set<T> getTargetsOf(T source);

}

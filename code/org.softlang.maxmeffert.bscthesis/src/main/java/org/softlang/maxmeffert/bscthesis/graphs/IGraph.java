package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Set;

public interface IGraph<T extends Comparable<T>> {

    Set<T> getVertices();
    Set<IPair<T,T>> getEdges();
    Set<T> getAdjacentVerticesOf(T vertex);
    boolean isEmpty();
    boolean contains(IPair<T,T> pair);
    boolean containsVertex(T vertex);
    boolean containsEdge(T source, T target);
    boolean containsEdge(IPair<T,T> edge);

}

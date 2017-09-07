package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;

import java.util.Set;

public interface IGraph<T extends Comparable<T>> {

    Set<T> getVertices();
    Set<IPair<T,T>> getEdges();
    Set<T> getAdjacentVerticesOf(T vertex);
    boolean isEmpty();
    boolean containsVertex(T vertex);
    boolean containsEdge(T source, T target);
    boolean containsEdge(IPair<T,T> edge);
    IAdjacencyMatrix toAdjacencyMatrix();

}

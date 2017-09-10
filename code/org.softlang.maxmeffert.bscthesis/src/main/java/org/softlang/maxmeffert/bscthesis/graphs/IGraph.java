package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Set;

public interface IGraph<T extends Comparable<T>> {

    Set<T> getVertices();
    Set<IPair<T,T>> getEdges();
    Set<T> getAdjacentVerticesOf(T vertex);
    int getVertexCount();
    int getEdgeCount();
    boolean isEmpty();

}

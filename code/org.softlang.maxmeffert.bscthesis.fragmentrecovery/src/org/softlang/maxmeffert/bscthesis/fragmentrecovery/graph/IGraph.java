package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IAdjacencyMatrix;

import java.util.Set;

public interface IGraph<T extends Comparable<T>> {

    Set<T> getVertices();
    Set<IPair<T,T>> getEdges();
    Set<T> getAdjacentVerticesOf(T vertex);
    boolean isEmpty();
    boolean containsVertex(T vertex);
    boolean containsEdge(T source, T target);
    IAdjacencyMatrix toAdjacencyMatrix();

}

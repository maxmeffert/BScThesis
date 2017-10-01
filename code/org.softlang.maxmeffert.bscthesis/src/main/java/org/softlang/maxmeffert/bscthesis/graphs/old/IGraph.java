package org.softlang.maxmeffert.bscthesis.graphs.old;

import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.Optional;
import java.util.Set;

public interface IGraph<T extends Comparable<T>> extends Iterable<T> {

    Optional<T> getFirstVertex();
    Set<T> getVertices();
    Set<IPair<T,T>> getEdges();
    Set<T> getAdjacentVerticesOf(T vertex);
    int getVertexCount();
    int getEdgeCount();
    boolean isEmpty();

}

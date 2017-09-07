package org.softlang.maxmeffert.bscthesis.graphs.old;

import org.softlang.maxmeffert.bscthesis.utils.IAdjacencyMatrix;

public interface IGraph<T extends Comparable<T>> {

    boolean contains(T value);

    IAdjacencyMatrix getMatrix();


}

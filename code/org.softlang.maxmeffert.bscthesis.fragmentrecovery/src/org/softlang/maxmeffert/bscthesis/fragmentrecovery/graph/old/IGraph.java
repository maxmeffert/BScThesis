package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.old;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.IAdjacencyMatrix;

public interface IGraph<T extends Comparable<T>> {

    boolean contains(T value);

    IAdjacencyMatrix getMatrix();


}

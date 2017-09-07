package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs.old;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.utils.IAdjacencyMatrix;

public interface IGraph<T extends Comparable<T>> {

    boolean contains(T value);

    IAdjacencyMatrix getMatrix();


}

package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IAdjacencyMatrix;

public interface IGraph<T extends Comparable<T>> {

    boolean contains(T value);

    IAdjacencyMatrix getMatrix();


}

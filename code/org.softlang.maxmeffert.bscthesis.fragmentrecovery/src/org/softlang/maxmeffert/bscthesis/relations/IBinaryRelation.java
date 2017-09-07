package org.softlang.maxmeffert.bscthesis.relations;

import org.softlang.maxmeffert.bscthesis.utils.IAdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.function.Function;

public interface IBinaryRelation<T extends Comparable<T>> {

    Iterable<T> getValues();

    Iterable<IPair<T, T>> getPairs();

    IAdjacencyMatrix getAdjacencyMatrix();

    boolean contains(T value);

    boolean contains(T left, T right);

    boolean contains(IPair<T,T> pair);

    IBinaryRelation<T> map(Function<IAdjacencyMatrix, IAdjacencyMatrix> function);

}

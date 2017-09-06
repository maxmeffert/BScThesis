package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.IAdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.IPair;

import java.util.Set;
import java.util.function.Function;

public class ReflexiveTransitiveClosure<T extends Comparable<T>> implements IBinaryRelation<T> {

    public final IBinaryRelation<T> binaryRelation;

    public ReflexiveTransitiveClosure(Set<IPair<T, T>> elements) {
        binaryRelation = new BinaryRelation<>(elements).map(new FloydWarshall()::map);
    }

    @Override
    public Iterable getValues() {
        return binaryRelation.getValues();
    }

    @Override
    public Iterable<IPair<T,T>> getPairs() {
        return binaryRelation.getPairs();
    }

    @Override
    public IAdjacencyMatrix getAdjacencyMatrix() {
        return binaryRelation.getAdjacencyMatrix();
    }

    @Override
    public boolean contains(T value) {
        return binaryRelation.contains(value);
    }

    @Override
    public boolean contains(T left, T right) {
        return binaryRelation.contains(left, right);
    }

    @Override
    public boolean contains(IPair<T,T> pair) {
        return binaryRelation.contains(pair);
    }

    @Override
    public IBinaryRelation map(Function function) {
        return binaryRelation.map(function);
    }
}

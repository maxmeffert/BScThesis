package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.SortedSet;

public interface IBinaryRelation<T extends Comparable<T>> extends SortedSet<IComparablePair<T,T>> {

    void add(T a, T b);
    void remove(T a, T b);
    IBinaryRelation<T> getReflexiveClosure();
    IBinaryRelation<T> getTransitiveClosure();
    IBinaryRelation<T> getReflexiveTransitiveClosure();
}

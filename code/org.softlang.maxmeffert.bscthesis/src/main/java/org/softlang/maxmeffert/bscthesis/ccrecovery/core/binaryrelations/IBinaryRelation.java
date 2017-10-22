package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface IBinaryRelation<T extends Comparable<T>> extends SortedSet<IComparablePair<T,T>> {

    boolean add(T a, T b);
    boolean remove(T a, T b);
    boolean contains(T a, T b);

    SortedSet<T> getDomainElements();
    SortedSet<T> getDomainElements(Predicate<T> predicate);

    IBinaryRelation<T> getCopy();
    IBinaryRelation<T> getReflexiveClosure();
    IBinaryRelation<T> getTransitiveClosure();
    IBinaryRelation<T> getReflexiveTransitiveClosure();
}

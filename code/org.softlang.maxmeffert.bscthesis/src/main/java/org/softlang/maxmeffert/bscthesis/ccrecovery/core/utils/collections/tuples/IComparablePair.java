package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public interface IComparablePair<T1 extends Comparable<T1>, T2 extends Comparable<T2>>
        extends IPair<T1, T2>, Comparable<IComparablePair<T1, T2>> {
}
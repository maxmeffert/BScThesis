package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public interface IComparableTriple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>
        extends ITriple<T1,T2,T3>, Comparable<IComparableTriple<T1,T2,T3>> {
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples;

public interface IPair<T1 extends Comparable<T1>, T2 extends Comparable<T2>>
        extends Comparable<IPair<T1, T2>> {
        T1 getFirst();
        T2 getSecond();
}
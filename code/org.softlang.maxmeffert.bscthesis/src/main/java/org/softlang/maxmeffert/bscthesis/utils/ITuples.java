package org.softlang.maxmeffert.bscthesis.utils;

@Deprecated
public interface ITuples {
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>> IPair<T1,T2> newPair(T1 first, T2 second);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>, T3 extends Comparable<T3>> ITriple<T1,T2,T3> newTriple(T1 first, T2 second, T3 third);
}

package org.softlang.maxmeffert.bscthesis.utils;

public interface ITriple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> extends Comparable<ITriple<T1,T2,T3>> {
    T1 getFirst();
    T2 getSecond();
    T3 getThird();
}

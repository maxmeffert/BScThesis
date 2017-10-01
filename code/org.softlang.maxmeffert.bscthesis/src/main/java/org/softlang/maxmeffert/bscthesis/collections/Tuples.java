package org.softlang.maxmeffert.bscthesis.collections;

@Deprecated
public class Tuples implements ITuples {
    @Override
    public <T1 extends Comparable<T1>, T2 extends Comparable<T2>> IPair<T1, T2> newPair(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    @Override
    public <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> ITriple<T1, T2, T3> newTriple(T1 first, T2 second, T3 third) {
        return new Triple<>(first, second, third);
    }
}

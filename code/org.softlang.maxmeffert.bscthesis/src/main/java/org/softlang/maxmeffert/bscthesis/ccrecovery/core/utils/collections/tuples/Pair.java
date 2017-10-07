package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public class Pair<T1,T2> implements IPair<T1,T2> {

    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T1 getFirst() {
        return first;
    }

    @Override
    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

}

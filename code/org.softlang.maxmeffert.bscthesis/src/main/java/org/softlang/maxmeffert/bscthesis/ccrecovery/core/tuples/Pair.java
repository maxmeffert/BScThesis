package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples;

public class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements IPair<T1, T2> {

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

    @Override
    public int compareTo(IPair<T1, T2> abiPair) {
        int result = getFirst().compareTo(abiPair.getFirst());
        if (result == 0) {
            return getSecond().compareTo(abiPair.getSecond());
        }
        return result;
    }
}

package org.softlang.maxmeffert.bscthesis.fragmentrecovery.utils;

public class Pair<A extends Comparable<A>,B extends Comparable<B>> implements IPair<A,B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public A getFirst() {
        return first;
    }

    @Override
    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @Override
    public int compareTo(IPair<A, B> abiPair) {
        int result = first.compareTo(abiPair.getFirst());
        if (result == 0) {
            return second.compareTo(abiPair.getSecond());
        }
        return result;
    }
}

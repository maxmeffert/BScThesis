package org.softlang.maxmeffert.bscthesis.tuples;

public class Pair<TFirst extends Comparable<TFirst>, TSecond extends Comparable<TSecond>> implements IPair<TFirst, TSecond> {

    public static <TFirst extends Comparable<TFirst>, TSecond extends Comparable<TSecond>> Pair<TFirst,TSecond> of(TFirst first, TSecond second) {
        return new Pair<>(first, second);
    }

    private final TFirst first;
    private final TSecond second;

    public Pair(TFirst first, TSecond second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public TFirst getFirst() {
        return first;
    }

    @Override
    public TSecond getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @Override
    public int compareTo(IPair<TFirst, TSecond> abiPair) {
        int result = first.compareTo(abiPair.getFirst());
        if (result == 0) {
            return second.compareTo(abiPair.getSecond());
        }
        return result;
    }
}

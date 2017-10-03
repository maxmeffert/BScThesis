package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public class Triple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> implements ITriple<T1,T2,T3> {

    private final T1 first;
    private final T2 second;
    private final T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
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
    public T3 getThird() {
        return third;
    }

    @Override
    public int compareTo(ITriple<T1, T2, T3> triple) {
        int result = first.compareTo(triple.getFirst());
        if (result == 0) {
            result = second.compareTo(triple.getSecond());
            if (result == 0) {
                result = third.compareTo(triple.getThird());
            }
        }
        return 0;
    }
}

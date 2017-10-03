package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public class Triple<T1,T2,T3> implements ITriple<T1,T2,T3> {

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
    public String toString() {
        return "(" + first + "," + second + "," + third + ")";
    }
}

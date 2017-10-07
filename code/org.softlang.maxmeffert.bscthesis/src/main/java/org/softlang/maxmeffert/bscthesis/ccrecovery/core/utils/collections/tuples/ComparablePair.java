package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public class ComparablePair<T1 extends Comparable<T1>, T2 extends Comparable<T2>>
        extends Pair<T1,T2>
        implements IComparablePair<T1, T2> {

    public ComparablePair(T1 first, T2 second) {
        super(first, second);
    }

    @Override
    public int compareTo(IComparablePair<T1, T2> abiPair) {
        int result = getFirst().compareTo(abiPair.getFirst());
        if (result == 0) {
            return getSecond().compareTo(abiPair.getSecond());
        }
        return result;
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples;

public class ComparableTriple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>
        extends Triple<T1,T2,T3>
        implements IComparableTriple<T1,T2,T3> {

    public ComparableTriple(T1 first, T2 second, T3 third) {
        super(first,second,third);
    }

    @Override
    public int compareTo(IComparableTriple<T1, T2, T3> triple) {
        int result = getFirst().compareTo(triple.getFirst());
        if (result == 0) {
            result = getSecond().compareTo(triple.getSecond());
            if (result == 0) {
                result = getThird().compareTo(triple.getThird());
            }
        }
        return 0;
    }
}

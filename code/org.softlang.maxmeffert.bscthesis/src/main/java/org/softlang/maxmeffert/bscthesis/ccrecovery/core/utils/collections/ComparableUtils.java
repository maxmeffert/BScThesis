package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections;

public class ComparableUtils implements IComparableUtils {
    @Override
    public <T extends Comparable<T>> boolean areEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    @Override
    public <T extends Comparable<T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

    @Override
    public <T extends Comparable<T>> boolean isLessOrEqual(T a, T b) {
        return a.compareTo(b) <= 0;
    }

    @Override
    public <T extends Comparable<T>> boolean isGreater(T a, T b) {
        return a.compareTo(b) > 0;
    }

    @Override
    public <T extends Comparable<T>> boolean isGreaterOrEqual(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}

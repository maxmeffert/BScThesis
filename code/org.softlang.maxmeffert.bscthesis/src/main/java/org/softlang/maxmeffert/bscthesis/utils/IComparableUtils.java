package org.softlang.maxmeffert.bscthesis.utils;

public interface IComparableUtils {
    <T extends Comparable<T>> boolean areEqual(T a, T b);
    <T extends Comparable<T>> boolean isLess(T a, T b);
    <T extends Comparable<T>> boolean isLessOrEqual(T a, T b);
    <T extends Comparable<T>> boolean isGreater(T a, T b);
    <T extends Comparable<T>> boolean isGreaterOrEqual(T a, T b);
}

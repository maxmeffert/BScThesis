package org.softlang.maxmeffert.bscthesis.utils;

public interface IIterableUtils {
    <TValue> boolean contains(Iterable<TValue> iterable, TValue value);
    <TValue> Iterable<TValue> concat(Iterable<TValue>... iterables);
}

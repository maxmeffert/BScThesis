package org.softlang.maxmeffert.bscthesis.utils;

public interface IMapping<TKey extends Comparable<TKey>, TValue extends Comparable<TValue>> extends Iterable<IPair<TKey,TValue>> {
    boolean isEmpty();
    int size();
    Iterable<TKey> getKeys();
    Iterable<TValue> getValues();
    TValue getValue(TKey key);
}

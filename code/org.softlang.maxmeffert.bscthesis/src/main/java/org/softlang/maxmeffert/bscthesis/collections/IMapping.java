package org.softlang.maxmeffert.bscthesis.collections;

public interface IMapping<K,V> {
    Iterable<K> keys();
    V get(K key);
}

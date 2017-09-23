package org.softlang.maxmeffert.bscthesis.graphs;

public interface IMapping<K,V> {
    Iterable<K> keys();
    V get(K key);
}

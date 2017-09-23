package org.softlang.maxmeffert.bscthesis.collections;

import java.util.SortedMap;
import java.util.SortedSet;

public interface ICollectionFactory {
    <T extends Comparable<T>> SortedSet<T> newSortedSet();
    <K extends Comparable<K>, V> SortedMap<K,V> newSortedMap();
}

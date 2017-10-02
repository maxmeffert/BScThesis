package org.softlang.maxmeffert.bscthesis.utils;

import java.util.SortedMap;
import java.util.SortedSet;

public interface ICollectionUtils {
    <TValue extends Comparable<TValue>> SortedSet<TValue> copySortedSet(SortedSet<TValue> sortedSet);
    <TKey extends Comparable<TKey>,TValue extends Comparable<TValue>> SortedMap<TKey,TValue> copySortedMap(SortedMap<TKey,TValue> sortedMap);
}

package org.softlang.maxmeffert.bscthesis.utils;

import java.util.*;

public interface ICollectionFactory {
    <T> Collection<T> newSingleton(T value);
    <T> List<T> newList();
    <T> Stack<T> newStack();
    <T extends Comparable<T>> SortedSet<T> newSortedSet();
    <TKey extends Comparable<TKey>, TValue> SortedMap<TKey, TValue> newSortedMap();
    <TKey extends Comparable<TKey>, TValue extends Comparable<TValue>> IMapping<TKey,TValue> newMapping(Map<TKey,TValue> map);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>> IPair<T1,T2> newPair(T1 first, T2 second);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>, T3 extends Comparable<T3>> ITriple<T1,T2,T3> newTriple(T1 first, T2 second, T3 third);
}

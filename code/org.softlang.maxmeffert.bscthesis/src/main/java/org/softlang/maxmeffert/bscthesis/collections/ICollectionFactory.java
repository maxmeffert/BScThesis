package org.softlang.maxmeffert.bscthesis.collections;

import java.util.SortedMap;
import java.util.SortedSet;

public interface ICollectionFactory {
    <T extends Comparable<T>> SortedSet<T> newSortedSet();
    <K extends Comparable<K>, V> SortedMap<K,V> newSortedMap();
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>> IPair<T1,T2> newPair(T1 first, T2 second);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>, T3 extends Comparable<T3>> ITriple<T1,T2,T3> newTriple(T1 first, T2 second, T3 third);
}

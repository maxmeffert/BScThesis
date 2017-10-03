package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparableTriple;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.CollectionView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ICollectionView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

import java.util.*;

public interface ICollectionFactory {
    <T> Collection<T> newSingleton(T value);
    <T> List<T> newList();
    <T> Stack<T> newStack();
    <T> Stack<T> newStackWith(T... initialValues);
    <T extends Comparable<T>> SortedSet<T> newSortedSet();
    <TKey extends Comparable<TKey>, TValue> SortedMap<TKey, TValue> newSortedMap();

    <T1,T2> IPair<T1,T2> newPair(T1 first, T2 second);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>> IComparablePair<T1,T2> newComparablePair(T1 first, T2 second);
    <T1 extends Comparable<T1>,T2 extends Comparable<T2>, T3 extends Comparable<T3>> IComparableTriple<T1,T2,T3> newComparableTriple(T1 first, T2 second, T3 third);

    <T> ICollectionView<T> newCollectionView(Collection<T> collection);
    <T> ISetView<T> newSetView(Set<T> set);
    <K,V> IMapView<K,V> newMapView(Map<K,V> map);
}

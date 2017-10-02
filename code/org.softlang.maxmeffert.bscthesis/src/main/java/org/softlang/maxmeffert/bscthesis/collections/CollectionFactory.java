package org.softlang.maxmeffert.bscthesis.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

public class CollectionFactory implements ICollectionFactory {

    @Override
    public <T> Collection<T> newSingleton(T value) {
        return Collections.singleton(value);
    }

    @Override
    public <T> List<T> newList() {
        return Lists.newLinkedList();
    }

    @Override
    public <T extends Comparable<T>> SortedSet<T> newSortedSet() {
        return Sets.newTreeSet();
    }

    @Override
    public <K extends Comparable<K>, V> SortedMap<K, V> newSortedMap() {
        return Maps.newTreeMap();
    }

    @Override
    public <TKey extends Comparable<TKey>, TValue extends Comparable<TValue>> IMapping<TKey, TValue> newMapping(Map<TKey, TValue> map) {
        return null;
    }

    @Override
    public <T1 extends Comparable<T1>, T2 extends Comparable<T2>> IPair<T1, T2> newPair(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    @Override
    public <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> ITriple<T1, T2, T3> newTriple(T1 first, T2 second, T3 third) {
        return new Triple<>(first, second, third);
    }
}

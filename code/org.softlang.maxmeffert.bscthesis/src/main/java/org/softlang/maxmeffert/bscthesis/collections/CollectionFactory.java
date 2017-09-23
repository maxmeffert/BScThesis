package org.softlang.maxmeffert.bscthesis.collections;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.SortedMap;
import java.util.SortedSet;

public class CollectionFactory implements ICollectionFactory {

    @Override
    public <T extends Comparable<T>> SortedSet<T> newSortedSet() {
        return Sets.newTreeSet();
    }

    @Override
    public <K extends Comparable<K>, V> SortedMap<K, V> newSortedMap() {
        return Maps.newTreeMap();
    }
}

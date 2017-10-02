package org.softlang.maxmeffert.bscthesis.core.utils;

import java.util.SortedMap;
import java.util.SortedSet;

public class CollectionUtils implements ICollectionUtils {

    private final ICollectionFactory collectionFactory;

    public CollectionUtils(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> SortedSet<TValue> copySortedSet(SortedSet<TValue> sortedSet) {
        SortedSet<TValue> result = collectionFactory.newSortedSet();
        result.addAll(sortedSet);
        return result;
    }

    @Override
    public <TKey extends Comparable<TKey>, TValue extends Comparable<TValue>> SortedMap<TKey, TValue> copySortedMap(SortedMap<TKey, TValue> sortedMap) {
        SortedMap<TKey,TValue> result = collectionFactory.newSortedMap();
        result.putAll(sortedMap);
        return result;
    }
}

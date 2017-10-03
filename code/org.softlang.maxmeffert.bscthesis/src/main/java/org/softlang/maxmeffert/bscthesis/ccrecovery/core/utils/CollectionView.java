package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionView<TValue> implements ICollectionView<TValue> {

    private final Collection<TValue> collection;

    public CollectionView(Collection<TValue> collection) {
        this.collection = collection;
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean contains(TValue value) {
        return collection.contains(value);
    }

    @Override
    public boolean containsAll(Collection<TValue> values) {
        return collection.containsAll(values);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Iterator<TValue> iterator() {
        return collection.iterator();
    }
}

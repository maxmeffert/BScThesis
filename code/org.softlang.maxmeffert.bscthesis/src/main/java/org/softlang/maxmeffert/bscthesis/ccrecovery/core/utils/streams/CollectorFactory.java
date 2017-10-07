package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.streams;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

import java.util.SortedSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorFactory implements ICollectorFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public CollectorFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> Collector<TValue, ?, SortedSet<TValue>> toSortedSet() {
        return Collectors.toCollection(collectionFactory::<TValue>newSortedSet);
    }
}

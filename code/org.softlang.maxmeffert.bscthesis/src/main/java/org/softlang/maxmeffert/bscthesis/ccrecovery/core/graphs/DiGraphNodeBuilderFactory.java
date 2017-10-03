package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.iterables.IIterableUtils;

public class DiGraphNodeBuilderFactory implements IDiGraphNodeBuilderFactory {

    private final IIterableUtils iterableUtils;
    private final ICollectionFactory collectionFactory;

    @Inject
    public DiGraphNodeBuilderFactory(IIterableUtils iterableUtils, ICollectionFactory collectionFactory) {
        this.iterableUtils = iterableUtils;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder() {
        return new DiGraphNodeBuilder<TValue>(collectionFactory, iterableUtils, null, collectionFactory.newSortedSet(), collectionFactory.newSortedSet());
    }

}

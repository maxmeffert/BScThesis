package org.softlang.maxmeffert.bscthesis.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.core.utils.IIterableUtils;

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
        return new DiGraphNodeBuilder<TValue>(iterableUtils, null, collectionFactory.newSortedSet(), collectionFactory.newSortedSet());
    }

}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.ICollectionFactory;

public class DiGraphBuilderFactory implements IDiGraphBuilderFactory {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public DiGraphBuilderFactory(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder() {
        return new DiGraphBuilder<TValue>(diGraphNodeBuilderFactory, collectionFactory, collectionFactory.newSortedMap());
    }
}

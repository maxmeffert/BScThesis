package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

public class DiGraphBuilderFactory implements IDiGraphBuilderFactory {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;

    @Inject
    public DiGraphBuilderFactory(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory, IViewFactory viewFactory) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder() {
        return new DiGraphBuilder<TValue>(diGraphNodeBuilderFactory, collectionFactory, viewFactory, collectionFactory.newSortedMap());
    }
}

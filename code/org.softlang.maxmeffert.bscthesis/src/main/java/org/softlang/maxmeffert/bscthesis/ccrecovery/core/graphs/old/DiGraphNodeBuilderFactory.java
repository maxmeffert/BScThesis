package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

public class DiGraphNodeBuilderFactory implements IDiGraphNodeBuilderFactory {

    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;

    @Inject
    public DiGraphNodeBuilderFactory(ICollectionFactory collectionFactory, IViewFactory viewFactory) {
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder() {
        return new DiGraphNodeBuilder<TValue>(collectionFactory, viewFactory, null, collectionFactory.newSortedSet(), collectionFactory.newSortedSet(), collectionFactory.newSortedSet());
    }

}

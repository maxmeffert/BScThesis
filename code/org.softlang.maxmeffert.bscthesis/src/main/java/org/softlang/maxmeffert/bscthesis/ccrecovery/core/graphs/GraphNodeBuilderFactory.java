package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

public class GraphNodeBuilderFactory implements IGraphNodeBuilderFactory {

    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;

    @Inject
    public GraphNodeBuilderFactory(ICollectionFactory collectionFactory, IViewFactory viewFactory) {
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder() {
        return new GraphNodeBuilder<TValue>(collectionFactory, viewFactory, null, collectionFactory.newSortedSet());
    }
}

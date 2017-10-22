package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

public class GraphBuilderFactory implements IGraphBuilderFactory {

    private final IGraphNodeBuilderFactory graphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;

    @Inject
    public GraphBuilderFactory(IGraphNodeBuilderFactory graphNodeBuilderFactory, ICollectionFactory collectionFactory, IViewFactory viewFactory) {
        this.graphNodeBuilderFactory = graphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return new GraphBuilder<TValue>(graphNodeBuilderFactory, collectionFactory, viewFactory, collectionFactory.newSortedMap());
    }
}

package org.softlang.maxmeffert.bscthesis.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.utils.ICollectionFactory;

public class GraphBuilderFactory implements IGraphBuilderFactory {

    private final IGraphNodeBuilderFactory graphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphBuilderFactory(IGraphNodeBuilderFactory graphNodeBuilderFactory, ICollectionFactory collectionFactory) {
        this.graphNodeBuilderFactory = graphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return new GraphBuilder<TValue>(graphNodeBuilderFactory, collectionFactory, collectionFactory.newSortedMap());
    }
}

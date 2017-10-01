package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class GraphNodeBuilderFactory implements IGraphNodeBuilderFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphNodeBuilderFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder() {
        return new GraphNodeBuilder<TValue>(null, collectionFactory.newSortedSet());
    }
}

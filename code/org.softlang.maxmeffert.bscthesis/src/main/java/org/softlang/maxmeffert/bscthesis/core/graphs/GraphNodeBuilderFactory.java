package org.softlang.maxmeffert.bscthesis.core.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.utils.ICollectionFactory;

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

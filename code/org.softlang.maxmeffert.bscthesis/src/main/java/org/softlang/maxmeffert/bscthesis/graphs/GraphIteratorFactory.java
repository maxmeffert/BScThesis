package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class GraphIteratorFactory implements IGraphIteratorFactory {
    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphIteratorFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphIterator<TValue> newGraphIterator(IGraph<TValue> graph, TValue startNode) {
        return new GraphIterator<>(graph, startNode, collectionFactory.newSortedSet(), collectionFactory.newStack());
    }
}

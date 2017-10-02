package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walkers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.ICollectionFactory;

public class GraphWalkerFactory implements IGraphWalkerFactory {
    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphWalkerFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphWalker<TValue> newGraphWalker() {
        return new GraphWalker<>(collectionFactory);
    }
}

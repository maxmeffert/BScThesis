package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class GraphWalkerFactory implements IGraphWalkerFactory {
    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphWalkerFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>> IGraphWalker<TNode> newGraphWalker() {
        return new DepthFirstSearchGraphWalker<>(collectionFactory);
    }
}

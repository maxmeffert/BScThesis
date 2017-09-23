package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class GraphWalkerFactory implements IGraphWalkerFactory {
    private final ICollectionFactory collectionFactory;

    public GraphWalkerFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IGraphWalker<TNode, TEdge> newGraphWalker() {
        return new DepthFirstSearchGraphWalker<>(collectionFactory);
    }
}

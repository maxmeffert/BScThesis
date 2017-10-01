package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class DiGraphNodeBuilderFactory implements IDiGraphNodeBuilderFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public DiGraphNodeBuilderFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>> IDiGraphNodeBuilder<TNode> newDiGraphNodeBuilder() {
        return new DiGraphNodeBuilder<TNode>(collectionFactory, null, collectionFactory.newSortedSet(), collectionFactory.newSortedSet());
    }

}

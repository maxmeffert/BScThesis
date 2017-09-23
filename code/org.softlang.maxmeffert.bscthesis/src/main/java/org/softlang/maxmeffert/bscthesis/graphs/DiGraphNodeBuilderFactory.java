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
    public <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IDiGraphNodeBuilder<TNode, TEdge> newDiGraphNodeBuilder() {
        return new DiGraphNodeBuilder<TNode,TEdge>(null, collectionFactory.newSortedMap(), collectionFactory.newSortedMap());
    }

    @Override
    public <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IDiGraphNodeBuilder<TNode, TEdge> newDiGraphNodeBuilderWithValue(TNode value) {
        return new DiGraphNodeBuilder<TNode,TEdge>(value, collectionFactory.newSortedMap(), collectionFactory.newSortedMap());
    }
}

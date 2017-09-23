package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class DiGraphBuilderFactory implements IDiGraphBuilderFactory {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public DiGraphBuilderFactory(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IDiGraphBuilder<TNode, TEdge> newDiGraphBuilder() {
        return new DiGraphBuilder<TNode,TEdge>(diGraphNodeBuilderFactory, collectionFactory, collectionFactory.newSortedMap());
    }
}

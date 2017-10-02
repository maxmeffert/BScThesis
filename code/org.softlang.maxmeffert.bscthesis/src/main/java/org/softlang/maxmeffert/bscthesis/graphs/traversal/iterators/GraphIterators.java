package org.softlang.maxmeffert.bscthesis.graphs.traversal.iterators;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;

public class GraphIterators implements IGraphIterators {

    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphIterators(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphIterator<TValue> newUndirectedGraphIterator(IGraph<TValue> graph, TValue startNode) {
        return new GeneralGraphIterator<>(graph::getAdjacentNodesOf, collectionFactory.newStackWith(startNode), collectionFactory.newSortedSet());
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphIterator<TValue> newDirectedGraphIterator(IDiGraph<TValue> graph, TValue startNode) {
        return new GeneralGraphIterator<>(graph::getSourceNodesOf, collectionFactory.newStackWith(startNode), collectionFactory.newSortedSet());
    }


}

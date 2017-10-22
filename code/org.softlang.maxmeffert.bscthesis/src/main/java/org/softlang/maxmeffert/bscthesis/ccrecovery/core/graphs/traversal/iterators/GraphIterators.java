package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

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
        return new GeneralGraphIterator<>(graph::getTargetNodesOf, collectionFactory.newStackWith(startNode), collectionFactory.newSortedSet());
    }


}

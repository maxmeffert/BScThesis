package org.softlang.maxmeffert.bscthesis.graphs.traversal.walkers;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;

import java.util.Set;

public class GraphWalker<TValue extends Comparable<TValue>> implements IGraphWalker<TValue> {

    private final ICollectionFactory collectionFactory;

    public GraphWalker(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    private void walk(IGraph<TValue> graph, TValue current, IGraphWalkerListener<TValue> graphWalkerListener, Set<TValue> discovered) {
        discovered.add(current);
        graphWalkerListener.enter(current);
        for(TValue next : graph.getAdjacentNodesOf(current)) {
            if (!discovered.contains(next)) {
                walk(graph, next, graphWalkerListener, discovered);
            }
        }
        graphWalkerListener.exit(current);
    }

    @Override
    public void walk(IGraph<TValue> graph, TValue start, IGraphWalkerListener<TValue> graphWalkerListener) {
        walk(graph, start, graphWalkerListener, collectionFactory.newSortedSet());
    }
}

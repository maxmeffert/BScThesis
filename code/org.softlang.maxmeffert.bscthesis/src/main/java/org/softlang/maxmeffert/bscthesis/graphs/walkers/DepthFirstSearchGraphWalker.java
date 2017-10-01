package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

import java.util.Set;

public class DepthFirstSearchGraphWalker<TValue extends Comparable<TValue>> implements IGraphWalker<TValue> {

    private final ICollectionFactory collectionFactory;

    public DepthFirstSearchGraphWalker(ICollectionFactory collectionFactory) {
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

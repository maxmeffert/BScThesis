package org.softlang.maxmeffert.bscthesis.graphs.walkers;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

import java.util.Set;

public class DepthFirstSearchGraphWalker<TNode extends Comparable<TNode>> implements IGraphWalker<TNode> {

    private final ICollectionFactory collectionFactory;

    public DepthFirstSearchGraphWalker(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    private void walk(IGraph<TNode> graph, TNode current, IGraphWalkerListener<TNode> graphWalkerListener, Set<TNode> discovered) {
        discovered.add(current);
        graphWalkerListener.enter(current);
        for(TNode next : graph.getAdjacentNodesOf(current)) {
            if (!discovered.contains(next)) {
                walk(graph, next, graphWalkerListener, discovered);
            }
        }
        graphWalkerListener.exit(current);
    }

    @Override
    public void walk(IGraph<TNode> graph, TNode start, IGraphWalkerListener<TNode> graphWalkerListener) {
        walk(graph, start, graphWalkerListener, collectionFactory.newSortedSet());
    }
}

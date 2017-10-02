package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.traversal.iterators.IGraphIterators;

import java.util.Iterator;

public class GraphWalk<TValue extends Comparable<TValue>> implements IGraphWalk<TValue> {

    private final IGraph<TValue> graph;
    private final TValue startNode;
    private final IGraphIterators graphIteratorFactory;

    public GraphWalk(IGraph<TValue> graph, TValue startNode, IGraphIterators graphIteratorFactory) {
        this.graph = graph;
        this.startNode = startNode;
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public Iterator<TValue> iterator() {
        return graphIteratorFactory.newUndirectedGraphIterator(graph, startNode);
    }
}

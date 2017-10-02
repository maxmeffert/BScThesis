package org.softlang.maxmeffert.bscthesis.graphs.traversal;

import org.softlang.maxmeffert.bscthesis.graphs.IGraph;

import java.util.Iterator;

public class GraphWalk<TValue extends Comparable<TValue>> implements IGraphWalk<TValue> {

    private final IGraph<TValue> graph;
    private final TValue startNode;
    private final IGraphIteratorFactory graphIteratorFactory;

    public GraphWalk(IGraph<TValue> graph, TValue startNode, IGraphIteratorFactory graphIteratorFactory) {
        this.graph = graph;
        this.startNode = startNode;
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public Iterator<TValue> iterator() {
        return graphIteratorFactory.newUndirectedGraphIterator(graph, startNode);
    }
}

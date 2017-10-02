package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;

public class GraphWalkFactory implements IGraphWalkFactory {

    private final IGraphIteratorFactory graphIteratorFactory;

    @Inject
    public GraphWalkFactory(IGraphIteratorFactory graphIteratorFactory) {
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode) {
        return new GraphWalk<>(graph, startNode, graphIteratorFactory);
    }
}

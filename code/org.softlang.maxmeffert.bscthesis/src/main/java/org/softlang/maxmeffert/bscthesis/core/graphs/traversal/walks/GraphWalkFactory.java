package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walks;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.traversal.iterators.IGraphIterators;

public class GraphWalkFactory implements IGraphWalkFactory {

    private final IGraphIterators graphIteratorFactory;

    @Inject
    public GraphWalkFactory(IGraphIterators graphIteratorFactory) {
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode) {
        return new GraphWalk<>(graph, startNode, graphIteratorFactory);
    }
}

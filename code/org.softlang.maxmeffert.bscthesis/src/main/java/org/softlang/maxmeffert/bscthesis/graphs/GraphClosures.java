package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Streams;
import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.stream.Collectors;

public class GraphClosures implements IGraphClosures {

    private final IGraphBuilders graphBuilders;
    private final IGraphWalkFactory graphWalkFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public GraphClosures(IGraphBuilders graphBuilders, IGraphWalkFactory graphWalkFactory, ICollectionFactory collectionFactory) {
        this.graphBuilders = graphBuilders;
        this.graphWalkFactory = graphWalkFactory;
        this.collectionFactory = collectionFactory;
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return graphBuilders.newGraphBuilder();
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder(IGraph<TValue> graph) {
        IGraphBuilder<TValue> builder = graphBuilders.newGraphBuilder();

        return builder;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> buildReflexivePairs(IGraph<TValue> graph) {
        return Streams.stream(graph.getNodes())
                .map(node -> collectionFactory.newPair(node,node))
                .collect(Collectors.toCollection(collectionFactory::newSortedSet));
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveClosureOf(IGraph<TValue> graph) {
        return graphBuilders.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(buildReflexivePairs(graph))
                .build();
    }
}

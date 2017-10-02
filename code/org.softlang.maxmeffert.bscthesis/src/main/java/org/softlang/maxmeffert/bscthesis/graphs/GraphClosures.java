package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.utils.ICollectorFactory;
import org.softlang.maxmeffert.bscthesis.utils.IPair;
import org.softlang.maxmeffert.bscthesis.utils.IStreamFactory;

public class GraphClosures implements IGraphClosures {

    private final IGraphBuilders graphBuilders;
    private final IGraphWalkFactory graphWalkFactory;
    private final ICollectionFactory collectionFactory;
    private final IStreamFactory streamFactory;
    private final ICollectorFactory collectorFactory;

    @Inject
    public GraphClosures(IGraphBuilders graphBuilders, IGraphWalkFactory graphWalkFactory, ICollectionFactory collectionFactory, IStreamFactory streamFactory, ICollectorFactory collectorFactory) {
        this.graphBuilders = graphBuilders;
        this.graphWalkFactory = graphWalkFactory;
        this.collectionFactory = collectionFactory;
        this.streamFactory = streamFactory;
        this.collectorFactory = collectorFactory;
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return graphBuilders.newGraphBuilder();
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder(IGraph<TValue> graph) {
        IGraphBuilder<TValue> builder = graphBuilders.newGraphBuilder();

        return builder;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> buildReflexivePairs(IGraph<TValue> graph) {
        return streamFactory.newStream(graph.getNodes())
                .map(node -> collectionFactory.newPair(node,node))
                .collect(collectorFactory.toSortedSet());
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveClosureOf(IGraph<TValue> graph) {
        return graphBuilders.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(buildReflexivePairs(graph))
                .build();
    }
}

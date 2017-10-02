package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.utils.IIterableUtils;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.SortedSet;

public class GraphClosures implements IGraphClosures {

    private final IGraphBuilders graphBuilders;
    private final IGraphWalkFactory graphWalkFactory;
    private final ICollectionFactory collectionFactory;
    private final IIterableUtils iterableUtils;

    @Inject
    public GraphClosures(IGraphBuilders graphBuilders, IGraphWalkFactory graphWalkFactory, ICollectionFactory collectionFactory, IIterableUtils iterableUtils) {
        this.graphBuilders = graphBuilders;
        this.graphWalkFactory = graphWalkFactory;
        this.collectionFactory = collectionFactory;
        this.iterableUtils = iterableUtils;
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return graphBuilders.newGraphBuilder();
    }

    private <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder(IGraph<TValue> graph) {
        IGraphBuilder<TValue> builder = graphBuilders.newGraphBuilder();

        return builder;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> getReflexiveEdges(IGraph<TValue> graph) {
        SortedSet<IPair<TValue,TValue>> pairs = collectionFactory.newSortedSet();
        for(TValue node : graph.getNodes()) {
            pairs.add(collectionFactory.newPair(node,node));
        }
        return pairs;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> getTransitiveEdges(IGraph<TValue> graph) {
        SortedSet<IPair<TValue,TValue>> pairs = collectionFactory.newSortedSet();
        for (TValue node : graph.getNodes()) {
            for (TValue transitiveNode : graphWalkFactory.newGraphWalk(graph, node)) {
                if (nodesAreNotAdjacent(graph, node, transitiveNode)) {
                    pairs.add(collectionFactory.newPair(node, transitiveNode));
                }
            }
        }
        return pairs;
    }

    private <TValue extends Comparable<TValue>> boolean nodesAreNotAdjacent(IGraph<TValue> graph, TValue node, TValue transitiveNode) {
        return !areEqual(node, transitiveNode) && !iterableUtils.contains(graph.getAdjacentNodesOf(transitiveNode), node);
    }

    private <TValue extends Comparable<TValue>> boolean areEqual(TValue node1, TValue node2) {
        return node1.compareTo(node2) == 0;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveClosureOf(IGraph<TValue> graph) {
        return graphBuilders.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getReflexiveEdges(graph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> transitiveClosureOf(IGraph<TValue> graph) {
        return graphBuilders.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getTransitiveEdges(graph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveTransitiveClosureOf(IGraph<TValue> graph) {
        return graphBuilders.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getReflexiveEdges(graph))
                .withEdges(getTransitiveEdges(graph))
                .build();
    }
}

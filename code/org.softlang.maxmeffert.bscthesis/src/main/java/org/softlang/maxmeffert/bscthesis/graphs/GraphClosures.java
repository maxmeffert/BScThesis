package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.utils.IComparableUtils;
import org.softlang.maxmeffert.bscthesis.utils.IIterableUtils;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.SortedSet;

public class GraphClosures implements IGraphClosures {

    private final IGraphBuilders graphBuilders;
    private final IGraphWalkFactory graphWalkFactory;
    private final ICollectionFactory collectionFactory;
    private final IIterableUtils iterableUtils;
    private final IComparableUtils comparableUtils;

    @Inject
    public GraphClosures(IGraphBuilders graphBuilders, IGraphWalkFactory graphWalkFactory, ICollectionFactory collectionFactory, IIterableUtils iterableUtils, IComparableUtils comparableUtils) {
        this.graphBuilders = graphBuilders;
        this.graphWalkFactory = graphWalkFactory;
        this.collectionFactory = collectionFactory;
        this.iterableUtils = iterableUtils;
        this.comparableUtils = comparableUtils;
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
                if (canAddAdjacentPair(graph, node, transitiveNode)) {
                    pairs.add(collectionFactory.newPair(node, transitiveNode));
                }
            }
        }
//        System.out.println(pairs);
        return pairs;
    }

    private <TValue extends Comparable<TValue>> boolean canAddAdjacentPair(IGraph<TValue> graph, TValue node, TValue transitiveNode) {
        return !areEqual(node, transitiveNode) && !areAdjacent(graph, node, transitiveNode);
    }

    private <TValue extends Comparable<TValue>> boolean areAdjacent(IGraph<TValue> graph, TValue node1, TValue node2) {
        return iterableUtils.contains(graph.getAdjacentNodesOf(node1), node2) || iterableUtils.contains(graph.getAdjacentNodesOf(node2), node1);
    }

    private <TValue extends Comparable<TValue>> boolean areEqual(TValue node1, TValue node2) {
        return comparableUtils.areEqual(node1, node2);
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

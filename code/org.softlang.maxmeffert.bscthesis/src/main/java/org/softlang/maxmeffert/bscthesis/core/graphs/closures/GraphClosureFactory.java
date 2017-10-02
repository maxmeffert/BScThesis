package org.softlang.maxmeffert.bscthesis.core.graphs.closures;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walks.IGraphWalkFactory;
import org.softlang.maxmeffert.bscthesis.core.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.core.utils.IComparableUtils;
import org.softlang.maxmeffert.bscthesis.core.utils.IIterableUtils;
import org.softlang.maxmeffert.bscthesis.core.utils.IPair;
import org.softlang.maxmeffert.bscthesis.core.graphs.IGraphBuilderFactory;

import java.util.SortedSet;

public class GraphClosureFactory implements IGraphClosureFactory {

    private final IGraphBuilderFactory graphBuilderFactory;
    private final IGraphWalkFactory graphWalkFactory;
    private final ICollectionFactory collectionFactory;
    private final IIterableUtils iterableUtils;
    private final IComparableUtils comparableUtils;

    @Inject
    public GraphClosureFactory(IGraphBuilderFactory graphBuilderFactory, IGraphWalkFactory graphWalkFactory, ICollectionFactory collectionFactory, IIterableUtils iterableUtils, IComparableUtils comparableUtils) {
        this.graphBuilderFactory = graphBuilderFactory;
        this.graphWalkFactory = graphWalkFactory;
        this.collectionFactory = collectionFactory;
        this.iterableUtils = iterableUtils;
        this.comparableUtils = comparableUtils;
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
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveGraphClosureOf(IGraph<TValue> graph) {
        return graphBuilderFactory.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getReflexiveEdges(graph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> transitiveGraphClosureOf(IGraph<TValue> graph) {
        return graphBuilderFactory.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getTransitiveEdges(graph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveTransitiveGraphClosureOf(IGraph<TValue> graph) {
        return graphBuilderFactory.<TValue>newGraphBuilder()
                .withGraph(graph)
                .withEdges(getReflexiveEdges(graph))
                .withEdges(getTransitiveEdges(graph))
                .build();
    }
}

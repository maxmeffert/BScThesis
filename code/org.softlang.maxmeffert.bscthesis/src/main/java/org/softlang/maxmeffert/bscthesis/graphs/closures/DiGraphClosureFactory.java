package org.softlang.maxmeffert.bscthesis.graphs.closures;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.graphs.IDiGraphBuilderFactory;
import org.softlang.maxmeffert.bscthesis.graphs.traversal.walks.IDiGraphWalkFactory;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.utils.IComparableUtils;
import org.softlang.maxmeffert.bscthesis.utils.IIterableUtils;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.SortedSet;

public class DiGraphClosureFactory implements IDiGraphClosureFactory {

    private final IDiGraphBuilderFactory diGraphBuilderFactory;
    private final IDiGraphWalkFactory diGraphWalkFactory;
    private final ICollectionFactory collectionFactory;
    private final IIterableUtils iterableUtils;
    private final IComparableUtils comparableUtils;

    @Inject
    public DiGraphClosureFactory(IDiGraphBuilderFactory diGraphBuilderFactory, IDiGraphWalkFactory diGraphWalkFactory, ICollectionFactory collectionFactory, IIterableUtils iterableUtils, IComparableUtils comparableUtils) {
        this.diGraphBuilderFactory = diGraphBuilderFactory;
        this.diGraphWalkFactory = diGraphWalkFactory;
        this.collectionFactory = collectionFactory;
        this.iterableUtils = iterableUtils;
        this.comparableUtils = comparableUtils;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> getReflexiveEdges(IDiGraph<TValue> diGraph) {
        SortedSet<IPair<TValue,TValue>> pairs = collectionFactory.newSortedSet();
        for(TValue node : diGraph.getNodes()) {
            pairs.add(collectionFactory.newPair(node,node));
        }
        return pairs;
    }

    private <TValue extends Comparable<TValue>> Iterable<IPair<TValue,TValue>> getTransitiveEdges(IDiGraph<TValue> diGraph) {
        SortedSet<IPair<TValue,TValue>> pairs = collectionFactory.newSortedSet();
        for (TValue node : diGraph.getNodes()) {
            for (TValue transitiveNode : diGraphWalkFactory.newDiGraphWalk(diGraph, node)) {
                if (canAddAdjacentPair(diGraph, node, transitiveNode)) {
                    pairs.add(collectionFactory.newPair(node, transitiveNode));
                }
            }
        }
        System.out.println(pairs);
        return pairs;
    }

    private <TValue extends Comparable<TValue>> boolean canAddAdjacentPair(IDiGraph<TValue> diGraph, TValue node, TValue transitiveNode) {
        return !areEqual(node, transitiveNode) && !areAdjacent(diGraph, node, transitiveNode);
    }

    private <TValue extends Comparable<TValue>> boolean areAdjacent(IDiGraph<TValue> diGraph, TValue node1, TValue node2) {
        return iterableUtils.contains(diGraph.getTargetNodesOf(node1), node2) || iterableUtils.contains(diGraph.getTargetNodesOf(node2), node1);
    }

    private <TValue extends Comparable<TValue>> boolean areEqual(TValue node1, TValue node2) {
        return comparableUtils.areEqual(node1, node2);
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphBuilderFactory.<TValue>newDiGraphBuilder()
                .withGraph(diGraph)
                .withEdges(getReflexiveEdges(diGraph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> transitiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphBuilderFactory.<TValue>newDiGraphBuilder()
                .withGraph(diGraph)
                .withEdges(getTransitiveEdges(diGraph))
                .build();
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveTransitiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphBuilderFactory.<TValue>newDiGraphBuilder()
                .withGraph(diGraph)
                .withEdges(getReflexiveEdges(diGraph))
                .withEdges(getTransitiveEdges(diGraph))
                .build();
    }
}

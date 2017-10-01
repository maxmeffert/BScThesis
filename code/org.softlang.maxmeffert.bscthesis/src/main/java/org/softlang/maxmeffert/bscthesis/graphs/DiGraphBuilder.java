package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.SortedMap;

public class DiGraphBuilder<TValue extends Comparable<TValue>> implements IDiGraphBuilder<TValue> {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final SortedMap<TValue, IDiGraphNodeBuilder<TValue>> nodeBuilders;

    public DiGraphBuilder(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory, SortedMap<TValue, IDiGraphNodeBuilder<TValue>> nodeBuilders) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.nodeBuilders = nodeBuilders;
    }

    private IDiGraphNodeBuilder<TValue> newBuilder(TValue node) {
        return diGraphNodeBuilderFactory.<TValue>newDiGraphNodeBuilder().withValue(node);
    }

    private IDiGraphNodeBuilder<TValue> getBuilder(TValue node) {
        if (!nodeBuilders.containsKey(node)) {
            nodeBuilders.put(node, newBuilder(node));
        }
        return nodeBuilders.get(node);
    }

    @Override
    public IDiGraphBuilder<TValue> withEdge(TValue node1, TValue node2) {
        getBuilder(node1).withTarget(node2);
        getBuilder(node2).withSource(node1);
        return this;
    }

    private SortedMap<TValue, IDiGraphNode<TValue>> buildNodes() {
        SortedMap<TValue, IDiGraphNode<TValue>> nodes = collectionFactory.newSortedMap();
        for (TValue key : nodeBuilders.keySet()) {
            nodes.put(key, nodeBuilders.get(key).build());
        }
        return nodes;
    }

    @Override
    public IDiGraph<TValue> build() {
        return new DiGraph<>(buildNodes());
    }
}

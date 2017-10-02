package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;

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

    private IDiGraphNodeBuilder<TValue> newDiGraphNodeBuilder(TValue node) {
        return diGraphNodeBuilderFactory.<TValue>newDiGraphNodeBuilder().withValue(node);
    }

    private void putDiGraphNodeBuilder(TValue value, IDiGraphNodeBuilder<TValue> diGraphNodeBuilder) {
        nodeBuilders.put(value, diGraphNodeBuilder);
    }

    private IDiGraphNodeBuilder<TValue> getDiGraphNodeBuilder(TValue node) {
        if (!hasDiGraphNodeBuilder(node)) {
            putDiGraphNodeBuilder(node, newDiGraphNodeBuilder(node));
        }
        return nodeBuilders.get(node);
    }

    private boolean hasDiGraphNodeBuilder(TValue node) {
        return nodeBuilders.containsKey(node);
    }

    private void updateDiGraphNodeBuilderSource(TValue value, TValue source) {
        putDiGraphNodeBuilder(value, getDiGraphNodeBuilder(value).withSource(source));
    }

    private void updateDiGraphNodeBuilderTarget(TValue value, TValue target) {
        putDiGraphNodeBuilder(value, getDiGraphNodeBuilder(value).withTarget(target));
    }

    @Override
    public IDiGraphBuilder<TValue> withEdge(TValue node1, TValue node2) {
        updateDiGraphNodeBuilderTarget(node1, node2);
        updateDiGraphNodeBuilderSource(node2, node1);
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

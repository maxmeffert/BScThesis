package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.SortedMap;

public class DiGraphBuilder<TNode extends Comparable<TNode>> implements IDiGraphBuilder<TNode> {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final SortedMap<TNode, IDiGraphNodeBuilder<TNode>> nodeBuilders;

    public DiGraphBuilder(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory, SortedMap<TNode, IDiGraphNodeBuilder<TNode>> nodeBuilders) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.nodeBuilders = nodeBuilders;
    }

    private IDiGraphNodeBuilder<TNode> newBuilder(TNode node) {
        return diGraphNodeBuilderFactory.<TNode>newDiGraphNodeBuilder().withValue(node);
    }

    private IDiGraphNodeBuilder<TNode> getBuilder(TNode node) {
        if (!nodeBuilders.containsKey(node)) {
            nodeBuilders.put(node, newBuilder(node));
        }
        return nodeBuilders.get(node);
    }

    @Override
    public IDiGraphBuilder<TNode> withEdge(TNode node1, TNode node2) {
        getBuilder(node1).withTarget(node2);
        getBuilder(node2).withSource(node1);
        return this;
    }

    private SortedMap<TNode, IDiGraphNode<TNode>> buildNodes() {
        SortedMap<TNode, IDiGraphNode<TNode>> nodes = collectionFactory.newSortedMap();
        for (TNode key : nodeBuilders.keySet()) {
            nodes.put(key, nodeBuilders.get(key).build());
        }
        return nodes;
    }

    @Override
    public IDiGraph<TNode> build() {
        return new DiGraph<>(buildNodes());
    }
}

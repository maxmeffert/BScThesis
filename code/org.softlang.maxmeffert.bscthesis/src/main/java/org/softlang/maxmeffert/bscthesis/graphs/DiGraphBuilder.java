package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.SortedMap;

public class DiGraphBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> implements IDiGraphBuilder<TNode, TEdge> {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final SortedMap<TNode, IDiGraphNodeBuilder<TNode,TEdge>> nodeBuilders;

    public DiGraphBuilder(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory, SortedMap<TNode, IDiGraphNodeBuilder<TNode, TEdge>> nodeBuilders) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.nodeBuilders = nodeBuilders;
    }

    private IDiGraphNodeBuilder<TNode,TEdge> newBuilder(TNode node) {
        return diGraphNodeBuilderFactory.<TNode,TEdge>newDiGraphNodeBuilder().withValue(node);
    }

    private IDiGraphNodeBuilder<TNode,TEdge> getBuilder(TNode node) {
        if (!nodeBuilders.containsKey(node)) {
            nodeBuilders.put(node, newBuilder(node));
        }
        return nodeBuilders.get(node);
    }

    @Override
    public DiGraphBuilder<TNode, TEdge> withEdge(TNode node1, TNode node2, TEdge edgeValue) {
        getBuilder(node1).withTargetEdge(node2, edgeValue);
        getBuilder(node2).withSourceEdge(node1, edgeValue);
        return this;
    }

    private SortedMap<TNode, IDiGraphNode<TNode,TEdge>> buildNodes() {
        SortedMap<TNode, IDiGraphNode<TNode,TEdge>> nodes = collectionFactory.newSortedMap();
        for (TNode key : nodeBuilders.keySet()) {
            nodes.put(key, nodeBuilders.get(key).build());
        }
        return nodes;
    }

    @Override
    public IDiGraph<TNode, TEdge> build() {
        return new DiGraph<>(buildNodes());
    }
}

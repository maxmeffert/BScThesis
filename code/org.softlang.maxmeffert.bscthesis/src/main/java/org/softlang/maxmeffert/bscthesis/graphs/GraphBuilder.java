package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.SortedMap;

public class GraphBuilder<TValue extends Comparable<TValue>> implements IGraphBuilder<TValue> {

    private final IGraphNodeBuilderFactory graphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final SortedMap<TValue, IGraphNodeBuilder<TValue>> nodeBuilders;

    public GraphBuilder(IGraphNodeBuilderFactory graphNodeBuilderFactory, ICollectionFactory collectionFactory, SortedMap<TValue, IGraphNodeBuilder<TValue>> nodeBuilders) {
        this.graphNodeBuilderFactory = graphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.nodeBuilders = nodeBuilders;
    }

    private IGraphNodeBuilder<TValue> newGraphNodeBuilder(TValue value) {
        return graphNodeBuilderFactory.<TValue>newGraphNodeBuilder().withValue(value);
    }

    private IGraphNodeBuilder<TValue> getGraphNodeBuilder(TValue value) {
        if (!containsGraphNodeBuilder(value)) {
            putGraphNodeBuilder(value,newGraphNodeBuilder(value));
        }
        return nodeBuilders.get(value);
    }

    private void putGraphNodeBuilder(TValue value, IGraphNodeBuilder<TValue> graphNodeBuilder) {
        nodeBuilders.put(value, graphNodeBuilder);
    }

    private boolean containsGraphNodeBuilder(TValue value) {
        return nodeBuilders.containsKey(value);
    }

    private void updateGraphNodeBuilderAdjacentNode(TValue value, TValue adjacentNode) {
        putGraphNodeBuilder(value, getGraphNodeBuilder(value).withAdjacentNode(adjacentNode));
    }

    @Override
    public IGraphBuilder<TValue> withEdge(TValue node1, TValue node2) {
        updateGraphNodeBuilderAdjacentNode(node1, node2);
        updateGraphNodeBuilderAdjacentNode(node2, node1);
        return new GraphBuilder<>(graphNodeBuilderFactory, collectionFactory, nodeBuilders);
    }

    private SortedMap<TValue, IGraphNode<TValue>> buildGraphNodes() {
        SortedMap<TValue, IGraphNode<TValue>> nodes = collectionFactory.newSortedMap();
        for (TValue value : nodeBuilders.keySet()) {
            nodes.put(value, getGraphNodeBuilder(value).build());
        }
        return nodes;
    }

    @Override
    public IGraph<TValue> build() {
        return new Graph<>(buildGraphNodes());
    }
}

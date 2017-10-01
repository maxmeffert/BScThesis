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
        if (!nodeBuilders.containsKey(value)) {
            nodeBuilders.put(value, newGraphNodeBuilder(value));
        }
        return nodeBuilders.get(value);
    }

    @Override
    public IGraphBuilder<TValue> withEdge(TValue node1, TValue node2) {
        getGraphNodeBuilder(node1).withAdjacentNode(node2);
        getGraphNodeBuilder(node2).withAdjacentNode(node1);
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

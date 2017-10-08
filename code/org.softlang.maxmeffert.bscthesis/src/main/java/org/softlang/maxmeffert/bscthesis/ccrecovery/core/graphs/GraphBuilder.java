package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

import java.util.SortedMap;

public class GraphBuilder<TValue extends Comparable<TValue>> implements IGraphBuilder<TValue> {

    private final IGraphNodeBuilderFactory graphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;
    private final SortedMap<TValue, IGraphNodeBuilder<TValue>> nodeBuilders;

    public GraphBuilder(IGraphNodeBuilderFactory graphNodeBuilderFactory, ICollectionFactory collectionFactory, IViewFactory viewFactory, SortedMap<TValue, IGraphNodeBuilder<TValue>> nodeBuilders) {
        this.graphNodeBuilderFactory = graphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
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
        return new GraphBuilder<>(graphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
    }

    public IGraphBuilder<TValue> withEdge(IComparablePair<TValue, TValue> edge) {
        return withEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public IGraphBuilder<TValue> withEdges(Iterable<IComparablePair<TValue, TValue>> edges) {
        IGraphBuilder<TValue> builder = new GraphBuilder<>(graphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
        for(IComparablePair<TValue,TValue> edge : edges) {
            builder = withEdge(edge);
        }
        return builder;
    }

    @Override
    public IGraphBuilder<TValue> withGraph(IGraph<TValue> graph) {
        IGraphBuilder<TValue> builder = new GraphBuilder<>(graphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
        for(TValue node : graph.getNodes()) {
            for (TValue adjacentNode : graph.getAdjacentNodesOf(node)) {
                builder = builder.withEdge(node, adjacentNode);
            }
        }
        return new GraphBuilder<>(graphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
    }

    private IMapView<TValue, IGraphNode<TValue>> buildGraphNodes() {
        SortedMap<TValue, IGraphNode<TValue>> nodes = collectionFactory.newSortedMap();
        for (TValue value : nodeBuilders.keySet()) {
            nodes.put(value, getGraphNodeBuilder(value).build());
        }
        return viewFactory.newMapView(nodes);
    }

    @Override
    public IGraph<TValue> build() {
        return new Graph<>(buildGraphNodes());
    }
}

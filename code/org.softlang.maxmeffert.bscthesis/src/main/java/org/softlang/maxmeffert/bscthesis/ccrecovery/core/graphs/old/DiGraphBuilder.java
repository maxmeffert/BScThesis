package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

import java.util.SortedMap;

public class DiGraphBuilder<TValue extends Comparable<TValue>> implements IDiGraphBuilder<TValue> {

    private final IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory;
    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;
    private final SortedMap<TValue, IDiGraphNodeBuilder<TValue>> nodeBuilders;

    public DiGraphBuilder(IDiGraphNodeBuilderFactory diGraphNodeBuilderFactory, ICollectionFactory collectionFactory, IViewFactory viewFactory, SortedMap<TValue, IDiGraphNodeBuilder<TValue>> nodeBuilders) {
        this.diGraphNodeBuilderFactory = diGraphNodeBuilderFactory;
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
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
    public IDiGraphBuilder<TValue> withEdge(TValue source, TValue target) {
        updateDiGraphNodeBuilderTarget(source, target);
        updateDiGraphNodeBuilderSource(target, source);
        return new DiGraphBuilder<>(diGraphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
    }

    @Override
    public IDiGraphBuilder<TValue> withEdge(IComparablePair<TValue, TValue> edge) {
        return withEdge(edge.getFirst(), edge.getSecond());
    }

    @Override
    public IDiGraphBuilder<TValue> withEdges(Iterable<IComparablePair<TValue, TValue>> edges) {
        IDiGraphBuilder<TValue> builder = new DiGraphBuilder<>(diGraphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
        for(IComparablePair<TValue,TValue> edge : edges) {
            builder = builder.withEdge(edge);
        }
        return builder;
    }

    @Override
    public IDiGraphBuilder<TValue> withGraph(IDiGraph<TValue> diGraph) {
        IDiGraphBuilder<TValue> builder = new DiGraphBuilder<>(diGraphNodeBuilderFactory, collectionFactory, viewFactory, nodeBuilders);
        for(TValue source : diGraph.getNodes()) {
            for (TValue target : diGraph.getTargetNodesOf(source)) {
                builder = builder.withEdge(source, target);
            }
        }
        return builder;
    }

    private IMapView<TValue, IDiGraphNode<TValue>> buildNodes() {
        SortedMap<TValue, IDiGraphNode<TValue>> nodes = collectionFactory.newSortedMap();
        for (TValue key : nodeBuilders.keySet()) {
            nodes.put(key, nodeBuilders.get(key).build());
        }
        return viewFactory.newMapView(nodes);
    }

    @Override
    public IDiGraph<TValue> build() {
        return new DiGraph<>(buildNodes());
    }
}

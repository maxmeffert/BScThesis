package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IViewFactory;

import java.util.SortedSet;

public class GraphNodeBuilder<TValue extends Comparable<TValue>> implements IGraphNodeBuilder<TValue> {

    private final ICollectionFactory collectionFactory;
    private final IViewFactory viewFactory;
    private final TValue value;
    private final SortedSet<TValue> adjacentNodes;

    public GraphNodeBuilder(ICollectionFactory collectionFactory, IViewFactory viewFactory, TValue value, SortedSet<TValue> adjacentNodes) {
        this.collectionFactory = collectionFactory;
        this.viewFactory = viewFactory;
        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public IGraphNodeBuilder<TValue> withValue(TValue value) {
        return new GraphNodeBuilder<>(collectionFactory, viewFactory, value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNode(TValue value) {
        adjacentNodes.add(value);
        return new GraphNodeBuilder<>(collectionFactory, viewFactory, this.value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNodes(Iterable<TValue> values) {
        IGraphNodeBuilder<TValue> builder = new GraphNodeBuilder<>(collectionFactory, viewFactory, value, adjacentNodes);
        for (TValue value : values) {
            builder = withAdjacentNode(value);
        }
        return builder;
    }

    private TValue buildValue()  {
        return value;
    }

    private IView<TValue> buildAdjacentNodes() {
        return viewFactory.newView(adjacentNodes);
    }

    @Override
    public IGraphNode<TValue> build() {
        return new GraphNode<>(buildValue(), buildAdjacentNodes());
    }
}

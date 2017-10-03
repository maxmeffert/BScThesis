package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

import java.util.SortedSet;

public class GraphNodeBuilder<TValue extends Comparable<TValue>> implements IGraphNodeBuilder<TValue> {

    private final ICollectionFactory collectionFactory;
    private final TValue value;
    private final SortedSet<TValue> adjacentNodes;

    public GraphNodeBuilder(ICollectionFactory collectionFactory, TValue value, SortedSet<TValue> adjacentNodes) {
        this.collectionFactory = collectionFactory;
        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public IGraphNodeBuilder<TValue> withValue(TValue value) {
        return new GraphNodeBuilder<>(collectionFactory, value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNode(TValue value) {
        adjacentNodes.add(value);
        return new GraphNodeBuilder<>(collectionFactory, this.value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNodes(Iterable<TValue> values) {
        IGraphNodeBuilder<TValue> builder = new GraphNodeBuilder<>(collectionFactory, value, adjacentNodes);
        for (TValue value : values) {
            builder = withAdjacentNode(value);
        }
        return builder;
    }

    private TValue buildValue()  {
        return value;
    }

    private ISetView<TValue> buildAdjacentNodes() {
        return collectionFactory.newSetView(adjacentNodes);
    }

    @Override
    public IGraphNode<TValue> build() {
        return new GraphNode<>(buildValue(), buildAdjacentNodes());
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import java.util.SortedSet;

public class GraphNodeBuilder<TValue extends Comparable<TValue>> implements IGraphNodeBuilder<TValue> {

    private final TValue value;
    private final SortedSet<TValue> adjacentNodes;

    public GraphNodeBuilder(TValue value, SortedSet<TValue> adjacentNodes) {
        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public IGraphNodeBuilder<TValue> withValue(TValue value) {
        return new GraphNodeBuilder<>(value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNode(TValue value) {
        adjacentNodes.add(value);
        return new GraphNodeBuilder<>(this.value, adjacentNodes);
    }

    @Override
    public IGraphNodeBuilder<TValue> withAdjacentNodes(Iterable<TValue> values) {
        IGraphNodeBuilder<TValue> builder = new GraphNodeBuilder<>(value, adjacentNodes);
        for (TValue value : values) {
            builder = withAdjacentNode(value);
        }
        return builder;
    }

    @Override
    public IGraphNode<TValue> build() {
        return new GraphNode<>(value, adjacentNodes);
    }
}

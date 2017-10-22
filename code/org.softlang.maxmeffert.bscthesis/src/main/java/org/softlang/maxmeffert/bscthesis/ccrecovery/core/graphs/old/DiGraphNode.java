package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final TValue value;
    private final IView<TValue> sourceNodes;
    private final IView<TValue> targetNodes;
    private final IView<TValue> adjacentNodes;

    public DiGraphNode(TValue value, IView<TValue> sourceNodes, IView<TValue> targetNodes, IView<TValue> adjacentNodes) {
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public IView<TValue> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public IView<TValue> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public IView<TValue> getAdjacentNodes() {
        return adjacentNodes;
    }

    @Override
    public int compareTo(IGraphNode<TValue> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

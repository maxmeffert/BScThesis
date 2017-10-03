package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.iterables.IIterableUtils;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final TValue value;
    private final ISetView<TValue> sourceNodes;
    private final ISetView<TValue> targetNodes;

    public DiGraphNode(TValue value, ISetView<TValue> sourceNodes, ISetView<TValue> targetNodes) {
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public ISetView<TValue> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public ISetView<TValue> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public ISetView<TValue> getAdjacentNodes() {
        return sourceNodes.union(targetNodes);
    }

    @Override
    public int compareTo(IGraphNode<TValue> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

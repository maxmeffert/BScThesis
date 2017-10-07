package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final TValue value;
    private final ISortedSetView<TValue> sourceNodes;
    private final ISortedSetView<TValue> targetNodes;

    public DiGraphNode(TValue value, ISortedSetView<TValue> sourceNodes, ISortedSetView<TValue> targetNodes) {
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public ISortedSetView<TValue> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public ISortedSetView<TValue> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public ISortedSetView<TValue> getAdjacentNodes() {
        return sourceNodes.union(targetNodes);
    }

    @Override
    public int compareTo(IGraphNode<TValue> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

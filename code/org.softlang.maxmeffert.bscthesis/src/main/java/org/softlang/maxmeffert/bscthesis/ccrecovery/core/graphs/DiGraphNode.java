package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.IIterableUtils;

import java.util.SortedSet;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final IIterableUtils iterableUtils;
    private final TValue value;
    private final SortedSet<TValue> sourceNodes;
    private final SortedSet<TValue> targetNodes;

    public DiGraphNode(IIterableUtils iterableUtils, TValue value, SortedSet<TValue> sourceNodes, SortedSet<TValue> targetNodes) {
        this.iterableUtils = iterableUtils;
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public Iterable<TValue> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public Iterable<TValue> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public Iterable<TValue> getAdjacentNodes() {
        return iterableUtils.concat(sourceNodes, targetNodes);
    }

    @Override
    public int compareTo(IGraphNode<TValue> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

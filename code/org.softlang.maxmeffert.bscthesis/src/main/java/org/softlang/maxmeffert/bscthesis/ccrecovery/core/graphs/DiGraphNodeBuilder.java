package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.IIterableUtils;

import java.util.SortedSet;

public class DiGraphNodeBuilder<TValue extends Comparable<TValue>> implements IDiGraphNodeBuilder<TValue> {

    private final IIterableUtils iterableUtils;
    private final TValue value;
    private final SortedSet<TValue> sourceNodes;
    private final SortedSet<TValue> targetNodes;


    public DiGraphNodeBuilder(IIterableUtils iterableUtils, TValue value, SortedSet<TValue> sourceNodes, SortedSet<TValue> targetNodes) {
        this.iterableUtils = iterableUtils;
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withValue(TValue value) {
        return new DiGraphNodeBuilder<>(iterableUtils, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withSource(TValue source) {
        sourceNodes.add(source);
        return new DiGraphNodeBuilder<>(iterableUtils, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TValue> withTarget(TValue target) {
        targetNodes.add(target);
        return new DiGraphNodeBuilder<>(iterableUtils, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNode<TValue> build() {
        return new DiGraphNode<>(iterableUtils, value, sourceNodes, targetNodes);
    }
}

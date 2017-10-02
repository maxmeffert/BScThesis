package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Iterables;

import java.util.SortedSet;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final TValue value;
    private final SortedSet<TValue> sourceNodes;
    private final SortedSet<TValue> targetNodes;


    public DiGraphNode(TValue value, SortedSet<TValue> sourceNodes, SortedSet<TValue> targetNodes) {
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
        return targetNodes;
//        return Iterables.concat(sourceNodes, targetNodes);
    }

    @Override
    public int compareTo(IGraphNode<TValue> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

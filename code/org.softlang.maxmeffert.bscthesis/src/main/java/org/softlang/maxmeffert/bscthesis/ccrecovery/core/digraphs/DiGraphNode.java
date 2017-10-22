package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import com.google.common.collect.Sets;

import java.util.SortedSet;

public class DiGraphNode<TValue extends Comparable<TValue>> implements IDiGraphNode<TValue> {

    private final TValue value;
    private final SortedSet<TValue> sourceNodes = Sets.newTreeSet();
    private final SortedSet<TValue> targetNodes = Sets.newTreeSet();

    public DiGraphNode(TValue value) {
        this.value = value;
    }

    @Override
    public TValue getValue() {
        return value;
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
    public void addSourceNode(TValue value) {
        sourceNodes.add(value);
    }

    @Override
    public void addTargetNode(TValue value) {
        targetNodes.add(value);
    }

    @Override
    public boolean hasSource(TValue source) {
        return sourceNodes.contains(source);
    }

    @Override
    public boolean hasTarget(TValue target) {
        return targetNodes.contains(target);
    }

    @Override
    public boolean isSourceOf(TValue target) {
        return hasTarget(target);
    }

    @Override
    public boolean isTargetOf(TValue source) {
        return hasSource(source);
    }


}

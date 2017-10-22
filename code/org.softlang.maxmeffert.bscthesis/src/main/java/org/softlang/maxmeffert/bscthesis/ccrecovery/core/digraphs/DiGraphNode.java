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
    public SortedSet<TValue> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public SortedSet<TValue> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public void addSourceNode(TValue source) {
        sourceNodes.add(source);
    }

    @Override
    public void removeSourceNode(TValue source) {
        sourceNodes.remove(source);
    }

    @Override
    public void addTargetNode(TValue target) {
        targetNodes.add(target);
    }

    @Override
    public void removeTargetNode(TValue target) {
        targetNodes.remove(target);
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

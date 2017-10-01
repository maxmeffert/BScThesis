package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Iterables;

import java.util.Collections;
import java.util.Optional;

public class TreeNode<TValue extends Comparable<TValue>> implements ITreeNode<TValue> {

    private final TValue value;
    private final Optional<TValue> parent;
    private final Iterable<TValue> children;

    public TreeNode(TValue value, Optional<TValue> parent, Iterable<TValue> children) {
        this.value = value;
        this.parent = parent;
        this.children = children;
    }


    @Override
    public boolean isRoot() {
        return !hasParent();
    }

    @Override
    public boolean isLeaf() {
        return !hasChildren();
    }

    @Override
    public boolean hasParent() {
        return parent.isPresent();
    }

    @Override
    public boolean hasChildren() {
        return children.iterator().hasNext();
    }

    @Override
    public Optional<TValue> getParent() {
        return parent;
    }

    @Override
    public Iterable<TValue> getChildren() {
        return children;
    }

    @Override
    public Iterable<TValue> getSourceNodes() {
        if (hasParent()) {
            return Collections.singleton(parent.get());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Iterable<TValue> getTargetNodes() {
        return children;
    }

    @Override
    public TValue getValue() {
        return value;
    }

    @Override
    public Iterable<TValue> getAdjacentNodes() {
        return Iterables.concat(getSourceNodes(),getTargetNodes());
    }

    @Override
    public int compareTo(IGraphNode<TValue> tNodeIGraphNode) {
        return value.compareTo(tNodeIGraphNode.getValue());
    }
}

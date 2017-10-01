package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;
import java.util.SortedSet;

public class TreeNodeBuilder<TValue extends Comparable<TValue>> implements ITreeNodeBuilder<TValue> {

    private final TValue value;
    private final TValue parent;
    private final SortedSet<TValue> children;

    public TreeNodeBuilder(TValue value, TValue parent, SortedSet<TValue> children) {
        this.value = value;
        this.parent = parent;
        this.children = children;
    }

    @Override
    public ITreeNodeBuilder<TValue> withValue(TValue value) {
        return new TreeNodeBuilder<>(value, parent, children);
    }

    @Override
    public ITreeNodeBuilder<TValue> withParent(TValue parent) {
        return new TreeNodeBuilder<>(value, parent, children);
    }

    @Override
    public ITreeNodeBuilder<TValue> withChild(TValue child) {
        children.add(child);
        return new TreeNodeBuilder<>(value, parent, children);
    }

    @Override
    public ITreeNode<TValue> build() {
        return new TreeNode<>(value, Optional.ofNullable(parent), children);
    }
}

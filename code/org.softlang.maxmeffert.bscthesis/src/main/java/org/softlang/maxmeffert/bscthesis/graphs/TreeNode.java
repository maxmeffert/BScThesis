package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public class TreeNode<TValue extends Comparable<TValue>> implements ITreeNode<TValue> {

    @Override
    public boolean isRoot() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean hasParent() {
        return false;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Optional<TValue> getParent() {
        return null;
    }

    @Override
    public Iterable<TValue> getChildren() {
        return null;
    }

    @Override
    public Iterable<TValue> getSourceNodes() {
        return null;
    }

    @Override
    public Iterable<TValue> getTargetNodes() {
        return null;
    }

    @Override
    public TValue getValue() {
        return null;
    }

    @Override
    public Iterable<TValue> getAdjacentNodes() {
        return null;
    }

    @Override
    public int compareTo(IGraphNode<TValue> tNodeIGraphNode) {
        return 0;
    }
}

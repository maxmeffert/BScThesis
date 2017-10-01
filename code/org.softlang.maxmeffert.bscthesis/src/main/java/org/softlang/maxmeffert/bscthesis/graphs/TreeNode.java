package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public class TreeNode<TNode extends Comparable<TNode>> implements ITreeNode<TNode> {

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
    public Optional<TNode> getParent() {
        return null;
    }

    @Override
    public Iterable<TNode> getChildren() {
        return null;
    }

    @Override
    public Iterable<TNode> getSourceNodes() {
        return null;
    }

    @Override
    public Iterable<TNode> getTargetNodes() {
        return null;
    }

    @Override
    public TNode getValue() {
        return null;
    }

    @Override
    public Iterable<TNode> getAdjacentNodes() {
        return null;
    }

    @Override
    public int compareTo(IGraphNode<TNode> tNodeIGraphNode) {
        return 0;
    }
}

package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.Optional;

public class Tree<TNode extends Comparable<TNode>> implements ITree<TNode> {


    @Override
    public TNode getRoot() {
        return null;
    }

    @Override
    public boolean isRoot(TNode tNode) {
        return false;
    }

    @Override
    public boolean hasParent(TNode tNode) {
        return false;
    }

    @Override
    public Optional<TNode> getParentOf(TNode tNode) {
        return null;
    }

    @Override
    public Iterable<TNode> getChildrenOf(TNode tNode) {
        return null;
    }

    @Override
    public Iterable<TNode> getSourceNodesOf(TNode tNode) {
        return null;
    }

    @Override
    public Iterable<TNode> getTargetNodesOf(TNode tNode) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getNodeCount() {
        return 0;
    }

    @Override
    public Iterable<TNode> getNodes() {
        return null;
    }

    @Override
    public Iterable<TNode> getAdjacentNodesOf(TNode tNode) {
        return null;
    }
}

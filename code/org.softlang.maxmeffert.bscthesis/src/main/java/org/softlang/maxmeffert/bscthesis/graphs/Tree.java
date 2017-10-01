package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public class Tree<TValue extends Comparable<TValue>> implements ITree<TValue> {


    @Override
    public TValue getRoot() {
        return null;
    }

    @Override
    public boolean isRoot(TValue tNode) {
        return false;
    }

    @Override
    public boolean hasParent(TValue tNode) {
        return false;
    }

    @Override
    public Optional<TValue> getParentOf(TValue tNode) {
        return null;
    }

    @Override
    public Iterable<TValue> getChildrenOf(TValue tNode) {
        return null;
    }

    @Override
    public Iterable<TValue> getSourceNodesOf(TValue tNode) {
        return null;
    }

    @Override
    public Iterable<TValue> getTargetNodesOf(TValue tNode) {
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
    public Iterable<TValue> getNodes() {
        return null;
    }

    @Override
    public Iterable<TValue> getAdjacentNodesOf(TValue tNode) {
        return null;
    }
}

package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;
import java.util.SortedMap;

public class Tree<TValue extends Comparable<TValue>> implements ITree<TValue> {

    private final TValue root;
    private final SortedMap<TValue, ITreeNode<TValue>> nodes;

    public Tree(TValue root, SortedMap<TValue, ITreeNode<TValue>> nodes) {
        this.root = root;
        this.nodes = nodes;
    }

    @Override
    public TValue getRoot() {
        return root;
    }

    @Override
    public boolean isRoot(TValue tNode) {
        return root.compareTo(tNode) == 0;
    }

    @Override
    public boolean hasParent(TValue tNode) {
        return false;
    }

    @Override
    public Optional<TValue> getParentOf(TValue tNode) {
        return nodes.get(tNode).getParent();
    }

    @Override
    public Iterable<TValue> getChildrenOf(TValue tNode) {
        return nodes.get(tNode).getChildren();
    }

    @Override
    public Iterable<TValue> getSourceNodesOf(TValue tNode) {
        return nodes.get(tNode).getSourceNodes();
    }

    @Override
    public Iterable<TValue> getTargetNodesOf(TValue tNode) {
        return nodes.get(tNode).getTargetNodes();
    }

    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    @Override
    public int getNodeCount() {
        return nodes.size();
    }

    @Override
    public Iterable<TValue> getNodes() {
        return null;
    }

    @Override
    public Iterable<TValue> getAdjacentNodesOf(TValue tNode) {
        return nodes.get(tNode).getAdjacentNodes();
    }
}

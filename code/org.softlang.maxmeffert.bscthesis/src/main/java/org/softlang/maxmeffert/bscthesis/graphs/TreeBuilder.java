package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.Optional;
import java.util.SortedMap;

public class TreeBuilder<TValue extends Comparable<TValue>> implements ITreeBuilder<TValue> {

    private final ICollectionFactory collectionFactory;
    private final ITreeNodeBuilderFactory treeNodeBuilderFactory;
    private final TValue root;
    private final SortedMap<TValue,ITreeNodeBuilder<TValue>> nodeBuilders;

    public TreeBuilder(ICollectionFactory collectionFactory, ITreeNodeBuilderFactory treeNodeBuilderFactory, TValue root, SortedMap<TValue, ITreeNodeBuilder<TValue>> nodeBuilders) {
        this.collectionFactory = collectionFactory;
        this.treeNodeBuilderFactory = treeNodeBuilderFactory;
        this.root = root;
        this.nodeBuilders = nodeBuilders;
    }

    private ITreeNodeBuilder<TValue> newTreeNodeBuilder(TValue value) {
        return treeNodeBuilderFactory.<TValue>newTreeNodeBuilder().withValue(value);
    }

    private void putTreeNodeBuilder(TValue value, ITreeNodeBuilder treeNodeBuilder) {
        nodeBuilders.put(value, treeNodeBuilder);
    }

    private ITreeNodeBuilder<TValue> getTreeNodeBuilder(TValue value) {
        if (!nodeBuilders.containsKey(value)) {
            putTreeNodeBuilder(value, newTreeNodeBuilder(value));
        }
        return nodeBuilders.get(value);
    }

    private void updateTreeNodeBuilderParent(TValue value, TValue parent) {
        putTreeNodeBuilder(value, getTreeNodeBuilder(value).withParent(parent));
    }

    private void updateTreeNodeBuilderParent(TValue value, Optional<TValue> parent) {
        if (parent.isPresent()) {
            updateTreeNodeBuilderParent(value, parent.get());
        }
    }

    private void updateTreeNodeBuilderChildren(TValue value, TValue child) {
        putTreeNodeBuilder(value, getTreeNodeBuilder(value).withChild(child));
    }

    private void updateTreeNodeBuilderChildren(TValue value, Iterable<TValue> children) {
        for(TValue child : children) {
            updateTreeNodeBuilderChildren(value, child);
        }
    }

    @Override
    public ITreeBuilder<TValue> withValue(TValue value) {
        nodeBuilders.put(value, newTreeNodeBuilder(value));
        return new TreeBuilder<>(collectionFactory, treeNodeBuilderFactory, value, nodeBuilders);
    }

    private void addTreeNodeBuildersFromTree(ITree<TValue> tree) {
        for(TValue value : tree.getNodes()) {
            updateTreeNodeBuilderParent(value, tree.getParentOf(value));
            updateTreeNodeBuilderChildren(value, tree.getChildrenOf(value));
        }
    }

    @Override
    public ITreeBuilder<TValue> withChild(ITreeBuilder<TValue> child) {
        ITree<TValue> tree = child.build();
        addTreeNodeBuildersFromTree(tree);
        updateTreeNodeBuilderParent(tree.getRoot(), root);
        return new TreeBuilder<>(collectionFactory, treeNodeBuilderFactory, root, nodeBuilders);
    }

    private SortedMap<TValue, ITreeNode<TValue>> buildTreeNodes() {
        SortedMap<TValue, ITreeNode<TValue>> nodes = collectionFactory.newSortedMap();
        for (TValue value : nodeBuilders.keySet()) {
            nodes.put(value, nodeBuilders.get(value).build());
        }
        System.out.println(nodes);
        return nodes;
    }

    @Override
    public ITree<TValue> build() {
        return new Tree<>(root, buildTreeNodes());
    }
}

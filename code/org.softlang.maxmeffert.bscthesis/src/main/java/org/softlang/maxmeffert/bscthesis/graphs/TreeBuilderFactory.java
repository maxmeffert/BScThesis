package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class TreeBuilderFactory implements ITreeBuilderFactory {

    private final ICollectionFactory collectionFactory;
    private final ITreeNodeBuilderFactory treeNodeBuilderFactory;

    @Inject
    public TreeBuilderFactory(ICollectionFactory collectionFactory, ITreeNodeBuilderFactory treeNodeBuilderFactory) {
        this.collectionFactory = collectionFactory;

        this.treeNodeBuilderFactory = treeNodeBuilderFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> ITreeBuilder<TValue> newTreeBuilder() {
        return new TreeBuilder<TValue>(collectionFactory, treeNodeBuilderFactory, null, collectionFactory.newSortedMap());
    }
}

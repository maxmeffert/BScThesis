package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class TreeNodeBuilderFactory implements ITreeNodeBuilderFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public TreeNodeBuilderFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> ITreeNodeBuilder<TValue> newTreeNodeBuilder() {
        return new TreeNodeBuilder<>();
    }
}

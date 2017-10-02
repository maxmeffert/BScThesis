package org.softlang.maxmeffert.bscthesis.trees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

public class TreeFactory implements ITreeFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public TreeFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> ITree<TValue> newTree(TValue value) {
        return new Tree<TValue>(value, collectionFactory.newList());
    }
}

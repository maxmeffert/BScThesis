package org.softlang.maxmeffert.bscthesis.graphs.trees;

public class TreeFactory implements ITreeFactory {
    @Override
    public <T> ITree<T> newTree() {
        return new Tree<>();
    }

    @Override
    public <T> ITree<T> newTreeWithValue(T value) {
        ITree<T> tree = newTree();
        tree.setValue(value);
        return tree;
    }
}

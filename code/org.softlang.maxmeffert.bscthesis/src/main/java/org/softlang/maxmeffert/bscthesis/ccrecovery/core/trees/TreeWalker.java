package org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees;

public class TreeWalker<TValue extends Comparable<TValue>> implements ITreeWalker<TValue> {
    @Override
    public void walk(ITree<TValue> tree, ITreeWalkerListener<TValue> listener) {
        listener.enter(tree);
        for(ITree<TValue> child : tree.getChildren()) {
            walk(child, listener);
        }
        listener.exit(tree);
    }
}

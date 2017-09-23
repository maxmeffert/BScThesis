package org.softlang.maxmeffert.bscthesis.graphs.trees;

public class TreeWalker<T> implements ITreeWalker<T> {

    @Override
    public void walk(ITree<T> tree, ITreeWalkerListener<T> treeWalkerListener) {
        treeWalkerListener.enter(tree);
        for(ITree<T> child : tree.getChildren()) {
            walk(child, treeWalkerListener);
        }
        treeWalkerListener.exit(tree);
    }
}

package org.softlang.maxmeffert.bscthesis.graphs.trees;

public interface ITreeWalker<T> {
    void walk(ITree<T> tree, ITreeWalkerListener<T> treeWalkerListener);
}

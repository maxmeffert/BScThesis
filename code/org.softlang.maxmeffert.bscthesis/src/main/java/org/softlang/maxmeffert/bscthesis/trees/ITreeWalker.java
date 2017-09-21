package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalker<T> {
    void walk(ITree<T> tree, ITreeWalkerListener<T> treeWalkerListener);
}

package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public interface ITreeWalker<T> {
    void walk(ITree<T> tree, ITreeWalkerListener<T> treeWalkerListener);
}

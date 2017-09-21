package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalkerListener<T> {
    void enter(ITree<T> tree);
    void exit(ITree<T> tree);
}

package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public interface ITreeWalkerListener<T> {
    void enter(ITree<T> tree);
    void exit(ITree<T> tree);
}

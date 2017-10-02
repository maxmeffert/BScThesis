package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalkerListener<TValue extends Comparable<TValue>> {
    void enter(ITree<TValue> tree);
    void exit(ITree<TValue> tree);
}

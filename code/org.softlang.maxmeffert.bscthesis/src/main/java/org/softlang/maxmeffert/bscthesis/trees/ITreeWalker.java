package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalker<TValue extends Comparable<TValue>> {
    void walk(ITree<TValue> tree, ITreeWalkerListener<TValue> listener);
}

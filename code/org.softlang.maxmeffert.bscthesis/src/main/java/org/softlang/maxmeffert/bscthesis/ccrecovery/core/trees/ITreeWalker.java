package org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees;

public interface ITreeWalker<TValue extends Comparable<TValue>> {
    void walk(ITree<TValue> tree, ITreeWalkerListener<TValue> listener);
}

package org.softlang.maxmeffert.bscthesis.core.trees;

public interface ITreeFactory {
    <TValue extends Comparable<TValue>> ITree<TValue> newTree(TValue value);
}

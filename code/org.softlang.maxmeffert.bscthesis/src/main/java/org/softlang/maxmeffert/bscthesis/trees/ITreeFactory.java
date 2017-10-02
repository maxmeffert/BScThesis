package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeFactory {
    <TValue extends Comparable<TValue>> ITree<TValue> newTree(TValue value);
}

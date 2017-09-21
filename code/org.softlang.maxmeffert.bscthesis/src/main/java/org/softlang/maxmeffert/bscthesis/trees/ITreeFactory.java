package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeFactory {
    <T> ITree<T> newTree();
    <T> ITree<T> newTreeWithValue(T value);
}

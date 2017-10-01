package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public interface ITreeFactory {
    <T> ITree<T> newTree();
    <T> ITree<T> newTreeWithValue(T value);
}

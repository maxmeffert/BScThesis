package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilder<TValue extends Comparable<TValue>> {

    ITree<TValue> build();
}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilder<TValue extends Comparable<TValue>> {

    ITreeBuilder<TValue> withValue(TValue value);

    ITreeBuilder<TValue> withChild(ITreeBuilder<TValue> child);

    ITree<TValue> build();
}

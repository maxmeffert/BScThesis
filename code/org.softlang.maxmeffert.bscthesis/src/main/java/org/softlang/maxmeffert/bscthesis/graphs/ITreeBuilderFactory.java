package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilderFactory {
    <TValue extends Comparable<TValue>> ITreeBuilder<TValue> newTreeBuilder();
}

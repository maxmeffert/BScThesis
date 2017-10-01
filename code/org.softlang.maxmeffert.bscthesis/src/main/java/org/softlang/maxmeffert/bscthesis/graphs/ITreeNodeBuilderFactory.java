package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeNodeBuilderFactory {
    <TValue extends Comparable<TValue>> ITreeNodeBuilder<TValue> newTreeNodeBuilder();
}

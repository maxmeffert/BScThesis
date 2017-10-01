package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilderFactory {
    <TNode extends Comparable<TNode>> ITreeBuilder<TNode> newTreeBuilder();
}

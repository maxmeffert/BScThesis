package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeNodeBuilderFactory {
    <TNode extends Comparable<TNode>> ITreeNodeBuilder<TNode> newTreeNodeBuilder();
}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface ITreeBuilderFactory {
    <TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>>
    ITreeBuilder<TNode,TEdge> newTreeBuilder();
}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilderFactory {
    <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IDiGraphBuilder<TNode,TEdge> newDiGraphBuilder();
}

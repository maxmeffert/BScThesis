package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphBuilderFactory {
    <TNode extends Comparable<TNode>> IDiGraphBuilder<TNode> newDiGraphBuilder();
}

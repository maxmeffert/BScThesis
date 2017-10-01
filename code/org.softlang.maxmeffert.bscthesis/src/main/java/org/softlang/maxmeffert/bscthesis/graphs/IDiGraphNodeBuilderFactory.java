package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNodeBuilderFactory {

    <TNode extends Comparable<TNode>> IDiGraphNodeBuilder<TNode> newDiGraphNodeBuilder();

}

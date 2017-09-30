package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNodeBuilderFactory {

    <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>>
    IDiGraphNodeBuilder<TNode,TEdge> newDiGraphNodeBuilder();

}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNodeBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {
    IDiGraphNodeBuilder<TNode, TEdge> withValue(TNode value);

    IDiGraphNodeBuilder<TNode, TEdge> withSourceEdge(TNode source, TEdge edgeValue);

    IDiGraphNodeBuilder<TNode, TEdge> withTargetEdge(TNode target, TEdge edgeValue);

    IDiGraphNode<TNode, TEdge> build();
}

package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNodeBuilder<TNode extends Comparable<TNode>> {

    IDiGraphNodeBuilder<TNode> withValue(TNode value);

    IDiGraphNodeBuilder<TNode> withSource(TNode source);

    IDiGraphNodeBuilder<TNode> withTarget(TNode target);

    IDiGraphNode<TNode> build();
}

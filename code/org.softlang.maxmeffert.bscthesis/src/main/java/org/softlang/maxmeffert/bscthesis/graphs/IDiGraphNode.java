package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraphNode<TNode extends Comparable<TNode>> extends IGraphNode<TNode> {
    Iterable<TNode> getSourceNodes();
    Iterable<TNode> getTargetNodes();
}

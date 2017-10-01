package org.softlang.maxmeffert.bscthesis.graphs;

public interface IGraphNode<TNode extends Comparable<TNode>> extends Comparable<IGraphNode<TNode>> {
    TNode getValue();
    Iterable<TNode> getAdjacentNodes();
}

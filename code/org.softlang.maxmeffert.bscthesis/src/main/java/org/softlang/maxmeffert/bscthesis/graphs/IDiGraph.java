package org.softlang.maxmeffert.bscthesis.graphs;

public interface IDiGraph<TNode extends Comparable<TNode>> extends IGraph<TNode> {
    Iterable<TNode> getSourceNodesOf(TNode node);
    Iterable<TNode> getTargetNodesOf(TNode node);
}

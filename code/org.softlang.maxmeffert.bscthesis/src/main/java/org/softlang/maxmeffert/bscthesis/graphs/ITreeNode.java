package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.tuples.IPair;

import java.util.Optional;

public interface ITreeNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends IDiGraphNode<TNode,TEdge> {
    Optional<TNode> getParentNode();
    Iterable<TNode> getChildNodes();
    Optional<IPair<TNode,TEdge>> getParentEdge();
    Iterable<IPair<TNode,TEdge>> getChildEdges();
}

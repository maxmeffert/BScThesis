package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public interface ITree<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> extends IDiGraph<TNode,TEdge> {

    TNode getRoot();

    boolean isRoot(TNode node);

    boolean hasParent(TNode node);

    Optional<TNode> getParentOf(TNode node);

    Iterable<TNode> getChildrenOf(TNode node);

}

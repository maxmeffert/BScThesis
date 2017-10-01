package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public interface ITree<TNode extends Comparable<TNode>> extends IDiGraph<TNode> {

    TNode getRoot();

    boolean isRoot(TNode node);

    boolean hasParent(TNode node);

    Optional<TNode> getParentOf(TNode node);

    Iterable<TNode> getChildrenOf(TNode node);

}

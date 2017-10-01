package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public interface ITree<TValue extends Comparable<TValue>> extends IDiGraph<TValue> {

    TValue getRoot();

    boolean isRoot(TValue node);

    boolean hasParent(TValue node);

    Optional<TValue> getParentOf(TValue node);

    Iterable<TValue> getChildrenOf(TValue node);

}

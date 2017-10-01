package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public interface ITreeNode<TValue extends Comparable<TValue>> extends IDiGraphNode<TValue> {
    boolean isRoot();
    boolean isLeaf();
    boolean hasParent();
    boolean hasChildren();
    Optional<TValue> getParent();
    Iterable<TValue> getChildren();
}

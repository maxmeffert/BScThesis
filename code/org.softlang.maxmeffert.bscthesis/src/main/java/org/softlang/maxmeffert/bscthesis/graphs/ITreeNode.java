package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Optional;

public interface ITreeNode<TNode extends Comparable<TNode>> extends IDiGraphNode<TNode> {
    boolean isRoot();
    boolean isLeaf();
    boolean hasParent();
    boolean hasChildren();
    Optional<TNode> getParent();
    Iterable<TNode> getChildren();
}

package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.Optional;
import java.util.SortedSet;

public class TreeNodeBuilder<TNode extends Comparable<TNode>> implements ITreeNodeBuilder<TNode> {


    @Override
    public ITreeNodeBuilder<TNode> withValue(TNode value) {
        return null;
    }

    @Override
    public ITreeNodeBuilder<TNode> withParent(TNode parent) {
        return null;
    }

    @Override
    public ITreeNodeBuilder<TNode> withChild(TNode child) {
        return null;
    }

    @Override
    public ITreeNode<TNode> build() {
        return null;
    }
}

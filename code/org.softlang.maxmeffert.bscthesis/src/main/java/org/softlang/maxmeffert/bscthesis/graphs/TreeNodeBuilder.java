package org.softlang.maxmeffert.bscthesis.graphs;

public class TreeNodeBuilder<TValue extends Comparable<TValue>> implements ITreeNodeBuilder<TValue> {


    @Override
    public ITreeNodeBuilder<TValue> withValue(TValue value) {
        return null;
    }

    @Override
    public ITreeNodeBuilder<TValue> withParent(TValue parent) {
        return null;
    }

    @Override
    public ITreeNodeBuilder<TValue> withChild(TValue child) {
        return null;
    }

    @Override
    public ITreeNode<TValue> build() {
        return null;
    }
}

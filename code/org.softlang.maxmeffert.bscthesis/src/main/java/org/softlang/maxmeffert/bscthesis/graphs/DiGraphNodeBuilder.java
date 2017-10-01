package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.SortedSet;

public class DiGraphNodeBuilder<TNode extends Comparable<TNode>> implements IDiGraphNodeBuilder<TNode> {

    private final ICollectionFactory collectionFactory;
    private final TNode value;
    private final SortedSet<TNode> sourceNodes;
    private final SortedSet<TNode> targetNodes;


    public DiGraphNodeBuilder(ICollectionFactory collectionFactory, TNode value, SortedSet<TNode> sourceNodes, SortedSet<TNode> targetNodes) {
        this.collectionFactory = collectionFactory;
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withValue(TNode value) {
        return new DiGraphNodeBuilder<>(collectionFactory, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withSource(TNode source) {
        sourceNodes.add(source);
        return new DiGraphNodeBuilder<>(collectionFactory, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withTarget(TNode target) {
        targetNodes.add(target);
        return new DiGraphNodeBuilder<>(collectionFactory, value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNode<TNode> build() {
        return new DiGraphNode<>(value, sourceNodes, targetNodes);
    }
}

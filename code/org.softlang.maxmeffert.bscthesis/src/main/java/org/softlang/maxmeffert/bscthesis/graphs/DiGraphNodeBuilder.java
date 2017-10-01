package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedSet;

public class DiGraphNodeBuilder<TNode extends Comparable<TNode>> implements IDiGraphNodeBuilder<TNode> {

    private final TNode value;
    private final SortedSet<TNode> sourceNodes;
    private final SortedSet<TNode> targetNodes;


    public DiGraphNodeBuilder(TNode value, SortedSet<TNode> sourceNodes, SortedSet<TNode> targetNodes) {
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withValue(TNode value) {
        return new DiGraphNodeBuilder<>(value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withSource(TNode source) {
        sourceNodes.add(source);
        return new DiGraphNodeBuilder<>(value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNodeBuilder<TNode> withTarget(TNode target) {
        targetNodes.add(target);
        return new DiGraphNodeBuilder<>(value, sourceNodes, targetNodes);
    }

    @Override
    public IDiGraphNode<TNode> build() {
        return new DiGraphNode<>(value, sourceNodes, targetNodes);
    }
}

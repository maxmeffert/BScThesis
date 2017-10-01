package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Iterables;
import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.SortedSet;

public class DiGraphNode<TNode extends Comparable<TNode>> implements IDiGraphNode<TNode> {

    private final TNode value;
    private final SortedSet<TNode> sourceNodes;
    private final SortedSet<TNode> targetNodes;


    public DiGraphNode(TNode value, SortedSet<TNode> sourceNodes, SortedSet<TNode> targetNodes) {
        this.value = value;
        this.sourceNodes = sourceNodes;
        this.targetNodes = targetNodes;
    }

    @Override
    public Iterable<TNode> getSourceNodes() {
        return sourceNodes;
    }

    @Override
    public Iterable<TNode> getTargetNodes() {
        return targetNodes;
    }

    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public Iterable<TNode> getAdjacentNodes() {
        return Iterables.concat(sourceNodes, targetNodes);
    }

    @Override
    public int compareTo(IGraphNode<TNode> iGraphNode) {
        return getValue().compareTo(iGraphNode.getValue());
    }
}

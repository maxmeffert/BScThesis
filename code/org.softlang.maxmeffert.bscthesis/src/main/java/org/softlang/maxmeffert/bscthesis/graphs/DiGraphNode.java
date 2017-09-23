package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Iterables;
import org.softlang.maxmeffert.bscthesis.tuples.IPair;

import java.util.SortedSet;

public class DiGraphNode<TNode extends Comparable<TNode>,TEdge extends Comparable<TEdge>> implements IDiGraphNode<TNode,TEdge> {

    private final TNode value;
    private final SortedSet<IPair<TNode,TEdge>> sourceEdges;
    private final SortedSet<IPair<TNode,TEdge>> targetEdges;

    public DiGraphNode(TNode value, SortedSet<IPair<TNode, TEdge>> sourceEdges, SortedSet<IPair<TNode, TEdge>> targetEdges) {
        this.value = value;
        this.sourceEdges = sourceEdges;
        this.targetEdges = targetEdges;
    }

    @Override
    public Iterable<IPair<TNode, TEdge>> getSourceEdges() {
        return sourceEdges;
    }

    @Override
    public Iterable<IPair<TNode, TEdge>> getTargetEdges() {
        return targetEdges;
    }

    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public Iterable<IPair<TNode, TEdge>> getAdjacentEdges() {
        return Iterables.concat(getSourceEdges(),getTargetEdges());
    }

    @Override
    public int compareTo(IGraphNode<TNode, TEdge> graphNode) {
        return value.compareTo(graphNode.getValue());
    }
}

package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.tuples.IPair;

import java.util.Map;
import java.util.Optional;

public class TreeNode<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> implements ITreeNode<TNode,TEdge> {

    private final TNode value;
    private final Optional<IPair<TNode,TEdge>> parentEdge;
    private final Iterable<IPair<TNode,TEdge>> childEdges;

    public TreeNode(TNode value, Optional<IPair<TNode, TEdge>> parentEdge, Iterable<IPair<TNode, TEdge>> childEdges) {
        this.value = value;
        this.parentEdge = parentEdge;
        this.childEdges = childEdges;
    }

    @Override
    public Optional<TNode> getParentNode() {
        return Optional.empty();
    }

    @Override
    public Iterable<TNode> getChildNodes() {
        return null;
    }

    @Override
    public Optional<IPair<TNode, TEdge>> getParentEdge() {
        return parentEdge;
    }

    @Override
    public Iterable<IPair<TNode, TEdge>> getChildEdges() {
        return null;
    }

    @Override
    public Iterable<TNode> getSourceNodes() {
        return null;
    }

    @Override
    public Iterable<TNode> getTargetNodes() {
        return null;
    }

    @Override
    public Map<TNode, TEdge> getSourceEdges() {
        return null;
    }

    @Override
    public Map<TNode, TEdge> getTargetEdges() {
        return null;
    }

    @Override
    public TNode getValue() {
        return null;
    }

    @Override
    public Iterable<TNode> getAdjacentNodes() {
        return null;
    }

    @Override
    public Map<TNode, TEdge> getAdjacentEdges() {
        return null;
    }

    @Override
    public int compareTo(IGraphNode<TNode, TEdge> tNodeTEdgeIGraphNode) {
        return 0;
    }
}

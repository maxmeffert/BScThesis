package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Map;
import java.util.SortedMap;

public class DiGraph<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> implements IDiGraph<TNode,TEdge> {

    private final SortedMap<TNode, IDiGraphNode<TNode,TEdge>> nodes;

    public DiGraph(SortedMap<TNode, IDiGraphNode<TNode, TEdge>> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    @Override
    public int getNodeCount() {
        return nodes.size();
    }

    @Override
    public Iterable<TNode> getNodes() {
        return nodes.keySet();
    }

    @Override
    public Iterable<TNode> getAdjacentNodesOf(TNode tNode) {
        return nodes.get(tNode).getAdjacentNodes();
    }

    @Override
    public Map<TNode, TEdge> getAdjacentEdgesOf(TNode tNode) {
        return nodes.get(tNode).getAdjacentEdges();
    }

    @Override
    public Iterable<TNode> getSourceNodesOf(TNode node) {
        return nodes.get(node).getSourceNodes();
    }

    @Override
    public Iterable<TNode> getTargetNodesOf(TNode node) {
        return nodes.get(node).getTargetNodes();
    }

    @Override
    public Map<TNode, TEdge> getSourceEdgesOf(TNode node) {
        return nodes.get(node).getSourceEdges();
    }

    @Override
    public Map<TNode, TEdge> getTargetEdgesOf(TNode node) {
        return nodes.get(node).getTargetEdges();
    }
}

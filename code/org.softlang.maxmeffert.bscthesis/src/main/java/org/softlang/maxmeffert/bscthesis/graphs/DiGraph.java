package org.softlang.maxmeffert.bscthesis.graphs;

import org.softlang.maxmeffert.bscthesis.collections.IPair;

import java.util.Map;
import java.util.SortedMap;

public class DiGraph<TNode extends Comparable<TNode>> implements IDiGraph<TNode> {

    private final SortedMap<TNode, IDiGraphNode<TNode>> nodes;

    public DiGraph(SortedMap<TNode, IDiGraphNode<TNode>> nodes) {
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
    public Iterable<TNode> getSourceNodesOf(TNode tNode) {
        return nodes.get(tNode).getSourceNodes();
    }

    @Override
    public Iterable<TNode> getTargetNodesOf(TNode tNode) {
        return nodes.get(tNode).getTargetNodes();
    }
}

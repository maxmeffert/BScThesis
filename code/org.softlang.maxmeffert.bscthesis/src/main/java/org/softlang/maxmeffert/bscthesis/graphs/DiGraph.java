package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedMap;

public class DiGraph<TValue extends Comparable<TValue>> implements IDiGraph<TValue> {

    private final SortedMap<TValue, IDiGraphNode<TValue>> nodes;

    public DiGraph(SortedMap<TValue, IDiGraphNode<TValue>> nodes) {
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
    public Iterable<TValue> getNodes() {
        return nodes.keySet();
    }

    @Override
    public Iterable<TValue> getAdjacentNodesOf(TValue tNode) {
        return nodes.get(tNode).getAdjacentNodes();
    }

    @Override
    public Iterable<TValue> getSourceNodesOf(TValue tNode) {
        return nodes.get(tNode).getSourceNodes();
    }

    @Override
    public Iterable<TValue> getTargetNodesOf(TValue tNode) {
        return nodes.get(tNode).getTargetNodes();
    }
}

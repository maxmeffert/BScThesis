package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedMap;

public class Graph<TValue extends Comparable<TValue>> implements IGraph<TValue> {

    private final SortedMap<TValue, IGraphNode<TValue>> nodes;

    public Graph(SortedMap<TValue, IGraphNode<TValue>> nodes) {
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
    public Iterable<TValue> getAdjacentNodesOf(TValue tValue) {
        return nodes.get(tValue).getAdjacentNodes();
    }
}

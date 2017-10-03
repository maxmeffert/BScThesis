package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.IMapView;

public class Graph<TValue extends Comparable<TValue>> implements IGraph<TValue> {

    private final IMapView<TValue, IGraphNode<TValue>> nodes;

    public Graph(IMapView<TValue, IGraphNode<TValue>> nodes) {
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

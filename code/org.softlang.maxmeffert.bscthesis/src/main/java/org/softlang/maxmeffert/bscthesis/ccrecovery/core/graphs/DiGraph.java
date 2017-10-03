package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.IMapView;

public class DiGraph<TValue extends Comparable<TValue>> implements IDiGraph<TValue> {

    private final IMapView<TValue, IDiGraphNode<TValue>> nodes;

    public DiGraph(IMapView<TValue, IDiGraphNode<TValue>> nodes) {
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

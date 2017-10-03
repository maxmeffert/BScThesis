package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

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
    public ISetView<TValue> getNodes() {
        return nodes.keySet();
    }

    @Override
    public ISetView<TValue> getAdjacentNodesOf(TValue tNode) {
        return nodes.get(tNode).getAdjacentNodes();
    }

    @Override
    public ISetView<TValue> getSourceNodesOf(TValue tNode) {
        return nodes.get(tNode).getSourceNodes();
    }

    @Override
    public ISetView<TValue> getTargetNodesOf(TValue tNode) {
        return nodes.get(tNode).getTargetNodes();
    }
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISetView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

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
    public ISortedSetView<TValue> getAdjacentNodesOf(TValue tNode) {
        return nodes.get(tNode).getAdjacentNodes();
    }

    @Override
    public ISortedSetView<TValue> getSourceNodesOf(TValue tNode) {
        return nodes.get(tNode).getSourceNodes();
    }

    @Override
    public ISortedSetView<TValue> getTargetNodesOf(TValue tNode) {
        return nodes.get(tNode).getTargetNodes();
    }
}

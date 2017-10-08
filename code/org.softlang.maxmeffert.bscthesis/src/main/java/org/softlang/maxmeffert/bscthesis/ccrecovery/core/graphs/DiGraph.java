package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;


import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public class DiGraph<TValue extends Comparable<TValue>> extends AbstractGraph<TValue> implements IDiGraph<TValue> {

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
        return nodes.count();
    }

    @Override
    public IView<TValue> getNodes() {
        return nodes.keys();
    }

    @Override
    public IView<TValue> getAdjacentNodesOf(TValue tNode) {
        return nodes.valueOf(tNode).getAdjacentNodes();
    }

    @Override
    public IView<TValue> getSourceNodesOf(TValue tNode) {
        return nodes.valueOf(tNode).getSourceNodes();
    }

    @Override
    public IView<TValue> getTargetNodesOf(TValue tNode) {
        return nodes.valueOf(tNode).getTargetNodes();
    }
}

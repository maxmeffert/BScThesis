package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public class Graph<TValue extends Comparable<TValue>> extends AbstractGraph<TValue> implements IGraph<TValue> {

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
        return nodes.count();
    }

    @Override
    public IView<TValue> getNodes() {
        return nodes.keys();
    }

    @Override
    public IView<TValue> getAdjacentNodesOf(TValue tValue) {
        return nodes.valueOf(tValue).getAdjacentNodes();
    }

}

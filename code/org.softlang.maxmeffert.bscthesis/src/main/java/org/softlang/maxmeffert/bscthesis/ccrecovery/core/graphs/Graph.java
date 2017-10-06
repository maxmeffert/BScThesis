package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISetView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedMapView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public class Graph<TValue extends Comparable<TValue>> implements IGraph<TValue> {

    private final ISortedMapView<TValue, IGraphNode<TValue>> nodes;

    public Graph(ISortedMapView<TValue, IGraphNode<TValue>> nodes) {
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
    public ISortedSetView<TValue> getAdjacentNodesOf(TValue tValue) {
        return nodes.get(tValue).getAdjacentNodes();
    }
}

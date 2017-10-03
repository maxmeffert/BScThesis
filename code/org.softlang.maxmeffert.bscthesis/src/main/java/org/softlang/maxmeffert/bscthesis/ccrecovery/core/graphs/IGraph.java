package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

public interface IGraph<TValue extends Comparable<TValue>> {
    boolean isEmpty();
    int getNodeCount();
    ISetView<TValue> getNodes();
    ISetView<TValue> getAdjacentNodesOf(TValue node);
}

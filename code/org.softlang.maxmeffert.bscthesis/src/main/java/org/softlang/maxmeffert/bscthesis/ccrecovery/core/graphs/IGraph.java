package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IGraph<TValue extends Comparable<TValue>> {
    boolean isEmpty();
    int getNodeCount();
    IView<TValue> getNodes();
    IView<TValue> getAdjacentNodesOf(TValue node);
}

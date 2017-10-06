package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISetView;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public interface IGraph<TValue extends Comparable<TValue>> {
    boolean isEmpty();
    int getNodeCount();
    ISetView<TValue> getNodes();
    ISortedSetView<TValue> getAdjacentNodesOf(TValue node);
}

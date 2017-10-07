package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public interface IDiGraph<TValue extends Comparable<TValue>> extends IGraph<TValue> {
    ISortedSetView<TValue> getSourceNodesOf(TValue node);
    ISortedSetView<TValue> getTargetNodesOf(TValue node);
}

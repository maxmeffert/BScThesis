package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public interface IGraphNode<TValue extends Comparable<TValue>> extends Comparable<IGraphNode<TValue>> {
    TValue getValue();
    ISortedSetView<TValue> getAdjacentNodes();
}

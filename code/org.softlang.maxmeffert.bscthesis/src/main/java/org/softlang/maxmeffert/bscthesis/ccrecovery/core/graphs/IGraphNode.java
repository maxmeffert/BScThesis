package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

public interface IGraphNode<TValue extends Comparable<TValue>> extends Comparable<IGraphNode<TValue>> {
    TValue getValue();
    ISetView<TValue> getAdjacentNodes();
}

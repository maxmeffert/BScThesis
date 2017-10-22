package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IGraphNode<TValue extends Comparable<TValue>> extends Comparable<IGraphNode<TValue>> {
    TValue getValue();
    IView<TValue> getAdjacentNodes();
}

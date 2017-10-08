package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IDiGraph<TValue extends Comparable<TValue>> extends IGraph<TValue> {
    IView<TValue> getSourceNodesOf(TValue node);
    IView<TValue> getTargetNodesOf(TValue node);
}

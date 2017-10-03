package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

public interface IDiGraph<TValue extends Comparable<TValue>> extends IGraph<TValue> {
    ISetView<TValue> getSourceNodesOf(TValue node);
    ISetView<TValue> getTargetNodesOf(TValue node);
}

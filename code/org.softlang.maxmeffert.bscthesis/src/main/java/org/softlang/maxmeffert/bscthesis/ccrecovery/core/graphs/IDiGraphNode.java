package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.ISetView;

public interface IDiGraphNode<TValue extends Comparable<TValue>> extends IGraphNode<TValue> {
    ISetView<TValue> getSourceNodes();
    ISetView<TValue> getTargetNodes();
}

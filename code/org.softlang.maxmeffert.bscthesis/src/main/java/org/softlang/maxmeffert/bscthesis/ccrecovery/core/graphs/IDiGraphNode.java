package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public interface IDiGraphNode<TValue extends Comparable<TValue>> extends IGraphNode<TValue> {
    ISortedSetView<TValue> getSourceNodes();
    ISortedSetView<TValue> getTargetNodes();
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

public interface IDiGraphNode<TValue extends Comparable<TValue>> extends IGraphNode<TValue> {
    IView<TValue> getSourceNodes();
    IView<TValue> getTargetNodes();
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

public interface IDiGraphNodeBuilder<TValue extends Comparable<TValue>> {

    IDiGraphNodeBuilder<TValue> withValue(TValue value);

    IDiGraphNodeBuilder<TValue> withSource(TValue source);

    IDiGraphNodeBuilder<TValue> withTarget(TValue target);

    IDiGraphNode<TValue> build();
}

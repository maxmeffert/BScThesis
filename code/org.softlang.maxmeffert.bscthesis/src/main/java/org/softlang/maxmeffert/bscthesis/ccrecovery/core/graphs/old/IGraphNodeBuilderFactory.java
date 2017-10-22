package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

public interface IGraphNodeBuilderFactory {
    <TValue extends Comparable<TValue>> IGraphNodeBuilder<TValue> newGraphNodeBuilder();
}

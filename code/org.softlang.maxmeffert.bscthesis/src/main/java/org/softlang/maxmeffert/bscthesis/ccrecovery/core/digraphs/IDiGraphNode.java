package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

public interface IDiGraphNode<TValue extends Comparable<TValue>> {
    TValue getValue();
    Iterable<TValue> getSourceNodes();
    Iterable<TValue> getTargetNodes();
    void addSourceNode(TValue value);
    void addTargetNode(TValue value);
    boolean hasSource(TValue source);
    boolean hasTarget(TValue target);
    boolean isSourceOf(TValue target);
    boolean isTargetOf(TValue source);
}

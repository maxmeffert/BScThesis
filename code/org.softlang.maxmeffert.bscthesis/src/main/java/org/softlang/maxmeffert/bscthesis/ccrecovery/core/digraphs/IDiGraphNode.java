package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import java.util.SortedSet;

public interface IDiGraphNode<TValue extends Comparable<TValue>> {
    TValue getValue();
    SortedSet<TValue> getSourceNodes();
    SortedSet<TValue> getTargetNodes();
    void addSourceNode(TValue source);
    void removeSourceNode(TValue source);
    void addTargetNode(TValue target);
    void removeTargetNode(TValue target);
    boolean hasSource(TValue source);
    boolean hasTarget(TValue target);
    boolean isSourceOf(TValue target);
    boolean isTargetOf(TValue source);
}

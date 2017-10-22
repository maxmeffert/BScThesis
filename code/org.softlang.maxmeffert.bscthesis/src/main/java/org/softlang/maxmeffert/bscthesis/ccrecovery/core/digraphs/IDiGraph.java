package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tuples.IPair;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface IDiGraph<TValue extends Comparable<TValue>> {
    SortedSet<TValue> getNodes();
    SortedSet<TValue> getNodes(Predicate<TValue> predicate);
    SortedSet<IPair<TValue, TValue>> getEdges();
    SortedSet<TValue> getSourceNodesOf(TValue value);
    SortedSet<TValue> getTargetNodesOf(TValue value);
    SortedSet<TValue> getSourceWalk(TValue start);
    SortedSet<TValue> getTargetWalk(TValue start);

    boolean addEdge(TValue source, TValue target);
    boolean addEdge(IPair<TValue, TValue> edge);
    boolean addEdges(Iterable<? extends IPair<TValue, TValue>> edges);
    boolean removeEdge(TValue source, TValue target);
    boolean removeEdge(IPair<TValue,TValue> edge);
    boolean removeEdges(Iterable<? extends IPair<TValue,TValue>> edges);

    boolean isEmpty();
    boolean hasNode(TValue value);
    boolean hasEdge(TValue source, TValue target);

    IDiGraph<TValue> getCopy();
    IDiGraph<TValue> getReflexiveClosure();
    IDiGraph<TValue> getTransitiveClosure();
    IDiGraph<TValue> getReflexiveTransitiveClosure();

    void clear();
}

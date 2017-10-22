package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IPair;

import java.util.function.Predicate;

public interface IDiGraph<TValue extends Comparable<TValue>> {
    Iterable<TValue> getNodes();
    Iterable<TValue> getNodes(Predicate<TValue> predicate);
    Iterable<IPair<TValue,TValue>> getEdges();
    Iterable<TValue> getSourceNodesOf(TValue value);
    Iterable<TValue> getTargetNodesOf(TValue value);
    Iterable<TValue> getSourceWalk(TValue start);
    Iterable<TValue> getTargetWalk(TValue start);
    void addEdge(TValue source, TValue target);
    void addEdge(IPair<TValue, TValue> edge);
    void addEdges(Iterable<IPair<TValue, TValue>> edges);
    boolean isEmpty();
    boolean hasNode(TValue value);
    boolean hasEdge(TValue source, TValue target);
    boolean allNodes(Predicate<TValue> predicate);
    boolean anyNodes(Predicate<TValue> predicate);
    boolean noneNodes(Predicate<TValue> predicate);
    IDiGraph<TValue> getCopy();
    IDiGraph<TValue> getReflexiveClosure();
    IDiGraph<TValue> getTransitiveClosure();
    IDiGraph<TValue> getReflexiveTransitiveClosure();
}

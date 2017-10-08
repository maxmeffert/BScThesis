package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

import java.util.function.Predicate;

public interface IGraph<TValue extends Comparable<TValue>> {
    boolean isEmpty();
    int getNodeCount();
    boolean all(Predicate<TValue> predicate);
    boolean any(Predicate<TValue> predicate);
    boolean none(Predicate<TValue> predicate);
    IView<TValue> getNodes();
    IView<TValue> getAdjacentNodesOf(TValue node);
    IView<TValue> filterNodes(Predicate<TValue> predicate);
}

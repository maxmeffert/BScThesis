package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IGraph;

public interface IGraphClosureFactory {
    <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveGraphClosureOf(IGraph<TValue> graph);
    <TValue extends Comparable<TValue>> IGraph<TValue> transitiveGraphClosureOf(IGraph<TValue> graph);
    <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveTransitiveGraphClosureOf(IGraph<TValue> graph);
}

package org.softlang.maxmeffert.bscthesis.core.graphs.closures;

import org.softlang.maxmeffert.bscthesis.core.graphs.IDiGraph;

public interface IDiGraphClosureFactory {
    <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveDiGraphClosureOf(IDiGraph<TValue> diGraph);
    <TValue extends Comparable<TValue>> IDiGraph<TValue> transitiveDiGraphClosureOf(IDiGraph<TValue> diGraph);
    <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveTransitiveDiGraphClosureOf(IDiGraph<TValue> diGraph);
}

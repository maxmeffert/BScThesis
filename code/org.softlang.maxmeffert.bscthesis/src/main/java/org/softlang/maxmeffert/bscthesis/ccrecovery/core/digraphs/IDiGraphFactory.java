package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

public interface IDiGraphFactory {
    <TValue extends Comparable<TValue>> IDiGraph<TValue> newDiGraph();
}

package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

public class DiGraphFactory implements IDiGraphFactory {
    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> newDiGraph() {
        return new DiGraph<>();
    }
}

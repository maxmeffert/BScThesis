package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;

import java.util.Iterator;
import java.util.Set;

public class Mereology<TValue extends Comparable<TValue>> implements IMereology<TValue> {

    private final IDiGraph<TValue> diGraph;

    public Mereology(IDiGraph<TValue> diGraph) {
        this.diGraph = diGraph;
    }


    @Override
    public boolean isEmpty() {
        return diGraph.isEmpty();
    }

    @Override
    public boolean contains(TValue value) {
        return false;
    }

    @Override
    public boolean isPartOf(TValue part, TValue fusion) {
        return false;
    }

    @Override
    public boolean isProperPartOf(TValue properPart, TValue fusion) {
        return false;
    }

    @Override
    public boolean isAtomOf(TValue atom, TValue fusion) {
        return false;
    }

    @Override
    public boolean isAtom(TValue value) {
        return false;
    }

    @Override
    public boolean isFusion(TValue value) {
        return false;
    }

    @Override
    public boolean isBottom(TValue value) {
        return false;
    }

    @Override
    public boolean isTop(TValue value) {
        return false;
    }

    @Override
    public TValue getBottom() {
        return null;
    }

    @Override
    public TValue getTop() {
        return null;
    }

    @Override
    public Iterable<TValue> getElements() {
        return diGraph.getNodes();
    }

    @Override
    public Iterable<TValue> getProperPartsOf(TValue value) {
        return null;
    }

    @Override
    public Iterable<TValue> getPartsOf(TValue value) {
        return diGraph.getSourceNodesOf(value);
    }

    @Override
    public Iterable<TValue> getAtomsOf(TValue value) {
        return null;
    }
}
